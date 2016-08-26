package com.myworkspace.me.scala

import akka.actor._

import scala.concurrent.Future
import scala.util.{Failure, Success}

case object SenderTriggerMessage
case class ReceiverTriggerMessage(futureList: Future[List[Integer]])
case class FailureReason(reason: String)
case class SuccessReason(reason: String)


object TestActor1 {
  val props: Props = Props.create(classOf[TestActor1])
}

class TestActor1 extends Actor with ActorLogging {

  override def receive: Receive = handleMessage orElse handleOtherMessages

  implicit val executionContext = context.dispatcher

  def handleMessage: Receive = {
    case msg@SenderTriggerMessage =>
      val senderRef = sender()
      context.dispatcher
      println("handleMessage Message Received !!!" + msg)
      senderRef ! ReceiverTriggerMessage(Future(List(1, 2, 3, 4)))
      senderRef ! List(1,2,3,4)

  }

  def handleOtherMessages: Receive = {
    case msg => println("handleOtherMessages Received !!!" + msg)
  }

}

object TestActor2 {
  def props(actorRef: ActorRef) = Props.create(classOf[TestActor2], actorRef)
}

class TestActor2(testActorRef: ActorRef) extends Actor {

  val testActorReference = testActorRef
  implicit val executionContext = context.dispatcher


  override def receive: Receive = {
    case msg: String => println("Received Test Message from Sender !!")
      testActorReference ! SenderTriggerMessage

     // val senderRef = sender()
      //TODO: Just to test Ask here !!
     /* import akka.pattern.ask
      import akka.util.Timeout
      import scala.concurrent.duration._
      implicit val timeout = Timeout(10 seconds)
      val eventualIntegers: Future[List[Integer]] = ask(testActorReference , SenderTriggerMessage).mapTo[List[Integer]]
      eventualIntegers.foreach(values => println("values" + values))
*/
      /*eventualIntegers onComplete {
        case Success(integerList) => println(s"Received eventualIntegers integerList ${integerList}")
        //senderRef ! SuccessReason("eventualIntegers SuccessFull for the list")
        case Failure(failure) =>
          println(s"Received failure  !!!" + failure)
        //senderRef ! FailureReason("eventualIntegers SuccessFull for the list")
      }*/



    case msg: ReceiverTriggerMessage =>
      val list: Future[List[Integer]] = msg.futureList
      val senderRef = sender()

      list onComplete {
        case Success(integerList) => println(s"Received integerList ${integerList}")
          senderRef ! SuccessReason("SuccessFull for the list")
        case Failure(failure) =>
          println(s"Received failure  !!!")
          senderRef ! FailureReason("SuccessFull for the list")
      }

     // println("millis"+ System.currentTimeMillis())
  }
}


object TestActor extends App {
  override def main(args: Array[String]) = {
    val actorSystem: ActorSystem = ActorSystem.create("TestActorSystem")
    val testActorRef1: ActorRef = actorSystem.actorOf(TestActor1.props)
    val testActorRef2: ActorRef = actorSystem.actorOf(TestActor2.props(testActorRef1))

    testActorRef2 ! "Hey Test Msg !!"

   /* import akka.pattern.ask
    import scala.concurrent.duration._
    implicit val timeout = Timeout(5 seconds)
    val durationTimeOut = Duration(5, SECONDS)
    val future = testActorRef2 ? "HeyTest Message"
    Await.result(future, durationTimeOut)*/

   // import akka.pattern.ask
    //import scala.concurrent.duration._
    //implicit val timeout = Timeout(5 seconds)

    //val eventualString: Future[String] = ask(testActorRef2, "Hey Test Message").mapTo[String]
    //println(s"Eventual String !!! ${eventualString}")




  }
}
