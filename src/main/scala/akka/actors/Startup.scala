package akka.actors

import akka.actor.{ActorRef, ActorSystem}
import akka.persistence.{SaveSnapShotInitialize}
import com.typesafe.config.{Config, ConfigFactory}


object Startup extends App{

  override def main(args:Array[String]) = {

    val config: Config = ConfigFactory.load("application.conf")
    val actorSystem = ActorSystem.create("TestActorSystem")
    val actorRef: ActorRef = actorSystem.actorOf(MySupervisor(config))

    actorRef ! Initialize()
    actorRef ! SaveSnapShotInitialize()

  }


}
