package akka.streams

import akka.actor.Actor.Receive
import akka.actor.{Props, Actor, Inbox, ActorSystem}
//import akka.stream.ActorFlowMaterializer
import akka.stream.scaladsl.{Sink, Source}


case class Message(val message: String)

object Influx{
 def props: Props = Props.create(classOf[Influx])
}

class Influx extends Actor {
  override def receive: Actor.Receive = {
    case msg: Message => println(s"Received Message $msg")
    case _ => println("Message didn't Match")
  }
}


object StreamExample2 extends App {

 /* implicit val actorSystem = ActorSystem.create("actorSystem")
  implicit val actorMaterializer = ActorFlowMaterializer()
  val influxActorRef = actorSystem.actorOf(Influx.props)

  val inbox = Inbox.create(actorSystem)
  val source = Source(() => Iterator.continually {
    val i = 0
    Thread.sleep(50)
    inbox.send(influxActorRef, Message(s"Sending Msg as a Stream with value $i and timestamp ${System.currentTimeMillis()}"))
  })

  val sink = Sink.ignore
  val flow = source.to(sink)

  flow.run()*/

}
