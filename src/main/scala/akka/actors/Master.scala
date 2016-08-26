package akka.actors

import akka.actor._
import akka.routing.ActorRefRoutee
import akka.routing.Router
import akka.routing.RoundRobinRoutingLogic

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

case object Work
case object ReplayInProcess




object Master extends App {

  override def main(args: Array[String]) = {
    val actorSystem: ActorSystem = ActorSystem.create("TestActorSystem2")
    val actorRef: ActorRef = actorSystem.actorOf(Props.create(classOf[Master1]))

    val ints: List[Int] = List(1, 2, 3, 4, 5, 6)

    import scala.concurrent.ExecutionContext.Implicits.global
    val replayMessages: Future[Boolean] = sendReplayMessages(actorRef, ints)

    replayMessages onComplete {
      case Success(success) => println("Replay Msgs are Complete So Sending now Work Msg!! " + success)
        actorRef ! `Work`
      case Failure(failure) => println("Failure !!!" + failure )
    }
  }


  def sendReplayMessages(actorRef: ActorRef, ints: List[Int])(implicit context: ExecutionContext): Future[Boolean] = {
    var counts = 0
    Future {
      for (value <- ints if (counts <= 6))
        yield {
          println("Sending ReplayInProcess Msg !!!")
          actorRef ! `ReplayInProcess`
          counts += 1
        }
      if (counts == 6) true else false
    }
  }
}

object Master1 {
  def apply: Props = Props.create(classOf[Master1])
}

class Master1 extends Actor {

  override def preStart() = {
    println("Starting pre-Start for Master1 !!")
  }

  var router = {
    val routees = Vector.fill(5) {
      val r = context.actorOf(Props[Worker])
      context watch r
      val routee = ActorRefRoutee(r)
      routee
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  def receive = {
    case w@`Work` =>
      println("Received Master1 msg work !!! " + w)
      router.route(w, sender())
    case r@`ReplayInProcess` =>
      println("Master Received msg ReplayInProcess Sending msg to Worker !!! ")
      router.route(r, sender())

    case Terminated(a) =>
      router = router.removeRoutee(a)
      val r = context.actorOf(Props[Worker])
      context watch r
      router = router.addRoutee(r)
  }
}


object Worker {
  def apply: Props = Props.create(classOf[Worker])
}

class Worker extends Actor with Stash {
  override def preStart() = {
    println("Starting pre-Start for Worker !!")
  }

  def receive: Receive = {
    case msg@ `Work` =>
      println("Received Msg Work !! UnStashing All Msg !!!")
      unstashAll()
    case msg@`ReplayInProcess` =>
      println("Received ReplayInProcess Actor Busy Stashing Msg !!!")
      stash()
  }
}
