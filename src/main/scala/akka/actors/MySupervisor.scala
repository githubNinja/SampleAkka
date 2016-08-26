package akka.actors

import java.util.UUID

import akka.actor.SupervisorStrategy.Restart
import akka.actor.TypedActor.Supervisor
import akka.actor._
import akka.persistence.{SaveSnapShotInitialize, MyPersistenceActor, StreamEvent}
import com.typesafe.config.Config

import scala.concurrent.Promise
import scala.concurrent.duration._

trait Boot {
  def startup(system: ActorSystem, config: Config): Promise[String]

  def shutdown(): Promise[String]
}

object MySupervisor {
  def apply(config: Config): Props = Props.create(classOf[MySupervisor], config)
}

case class Initialize()


class MySupervisor(val config: Config) extends Supervisor with Actor with ActorLogging with Boot {

  var actorSystem: ActorSystem = _
  var persistenceActor: Option[ActorRef] = None

  override def preStart() = {
    println("PreStart Invoked !!")
    persistenceActor = Some(context.actorOf(MyPersistenceActor(config)))
  }

  override def postStop()= {
    println("Post Stop Triggerd !!!")
    persistenceActor.get ! "SaveSnapShot"
  }

  override val supervisorStrategy = OneForOneStrategy(10, 1 minute) {
    case exception: Exception =>
      Restart
  }

  override def receive: Receive = {
    case msg@ Initialize()  => println(" MySupervisor Receive Method !! " + msg)
      val list = List(1,2,3,4,5)
      for (x <- list)
        yield {
          val randomValue: String = UUID.randomUUID().toString
          persistenceActor.get ! StreamEvent(s"TestStreamName-${randomValue.substring(1,5)}", randomValue, Some(x), true)
        }

    case msg @ SaveSnapShotInitialize () =>
      println("SuperVisor Received SaveSnapShot !!" + msg )
      persistenceActor.get ! msg

  }

  override def startup(system: ActorSystem, config: Config): Promise[String] = {
    println("Starting up !!!")
    Promise[String]

  }

  override def shutdown(): Promise[String] = {
    println("Shutting down !!!")
    Promise[String]
  }
}
