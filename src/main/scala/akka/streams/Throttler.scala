package akka.streams

import java.util.concurrent.TimeUnit

import akka.actor.{ActorSystem, ActorRef, Props, Actor}
import akka.contrib.throttle.Throttler.{SetTarget, Rate}
import akka.contrib.throttle.TimerBasedThrottler

import scala.concurrent.duration.Duration


class Printer extends Actor {

  override def receive: Actor.Receive = {
    case msg:Any =>
      println(s"Msg Received::${msg}")
  }
}

object ThrottlerMain extends App {
  val props: Props = Props.create(classOf[Throttler])
  val actorSystem = ActorSystem.create("ThrottlerActorSystem")
  actorSystem.actorOf(props)
  println("Throttler Main")
}

class Throttler extends Actor {

  val printerActorRef: ActorRef = context.actorOf(Props.create(classOf[Printer]))
  val throttlerActorRef: ActorRef = context.actorOf(Props(classOf[TimerBasedThrottler],(Rate(2 , Duration(3, TimeUnit.SECONDS )))))
  throttlerActorRef ! SetTarget(Some (printerActorRef))

  throttlerActorRef ! "Msg1"
  throttlerActorRef ! "Msg2"
  throttlerActorRef ! "Msg3"
  throttlerActorRef ! "Msg4"
  throttlerActorRef ! "Msg5"

  override def receive: Actor.Receive = {
    case msg:Any =>
      println(s"Msg Received::Throttler::Actor:${msg}")
  }


}
