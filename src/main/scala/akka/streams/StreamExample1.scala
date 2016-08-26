package akka.streams

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source}
//import akka.stream.{ActorFlowMaterializer}

import scala.concurrent.Future

object StreamExample1 extends App{

 /* implicit  val actorSystem = ActorSystem()
  implicit  val materializer = ActorFlowMaterializer()
  import actorSystem.dispatcher
  val sourceValue:Future[String] = Source("Hello World !!!".toList).map(_.toUpper).concat(Source("!!!"))
    .runWith(Sink.fold(""){ case (acc, c) => acc + c })

  sourceValue.onComplete {
  case text => println("Text ::"+ text )
    actorSystem.shutdown()
    import concurrent.duration._
    actorSystem.awaitTermination(10.seconds)
  }*/




}



