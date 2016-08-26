package com.myworkspace.me.scheduler

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}

case object Tick
case object SendMsg
case class Running(val elemntList: List[String])
case object DataDeletionInitiate
case class SendSessionGuid(val sessionValue: String)
case object SendEpochMsg
case object ReceivedEpochMsg

import akka.pattern.ask

object MyScheduler extends App {

  val actorSystem: ActorSystem = ActorSystem.create("MyActorSystem")
  val props1 = Props(classOf[Receiver], "ReceiverActor")
  val receiverActorRef: ActorRef = actorSystem.actorOf(props1)

  val props = Props(classOf[MyScheduler], "MySchedulerActor", receiverActorRef)
  val schedulerActorRef: ActorRef = actorSystem.actorOf(props)


  val initialDelay: FiniteDuration = FiniteDuration(2000, TimeUnit.MILLISECONDS)
  val duration: FiniteDuration = FiniteDuration(5000, TimeUnit.MILLISECONDS)

  import scala.concurrent.ExecutionContext.Implicits.global

  actorSystem.scheduler.schedule(initialDelay, duration, schedulerActorRef, DataDeletionInitiate)


}

class MyScheduler(actorName: String, receiveActor: ActorRef) extends Actor {

  import scala.concurrent.ExecutionContext.Implicits.global

  var jobRunning = false
  var stateList = List.empty[String]

  override def preStart() = {
    println("PreStart Msg !!!")
    jobRunning = false
  }


  override def receive: Receive = {
    case DataDeletionInitiate =>
      // println("Received DataDeletionInitiate Msg !!!")
      if (jobRunning == false) {
        println("Sending Tick Msg to Actor !!!")
        receiveActor ! Tick
        jobRunning = true
      }
    case msgRunning: Running =>
      println("Received State Running !!!")
      stateList = msgRunning.elemntList
      implicit val timeout = Timeout(3, TimeUnit.SECONDS)


      for( i <- stateList ) {
          println("sending msg !!" + i)
          val result = receiveActor ? SendSessionGuid(i)
          result onComplete {
            case Success(success) => println("Success !!!")
              receiveActor ! SendEpochMsg
            case Failure(failure) => println("Failure !!!")
          }
      }

    case _ =>
      println("Received Unhandled Msg !!!")

  }
}

class Receiver(actorName: String) extends Actor {

  import scala.concurrent.ExecutionContext.Implicits.global

  override def receive: Receive = {
    case Tick =>
      println("Receiver Received Tick Msg !!!")
      val elementList = List("1", "2", "3")
      sender() ! Running(elementList)
    case msg@SendSessionGuid(_) =>
      println("Received SendSessionGuid !!" + msg.sessionValue)
      sender() ! Future(true)
    case SendEpochMsg => sender() ! ReceivedEpochMsg
    case _ => println("Received Unhandled Msg !!!")

  }
}

