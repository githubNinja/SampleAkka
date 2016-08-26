package akkanotes.messaging.actor
import akka.actor.ActorSystem
import com.typesafe.config.{Config, ConfigFactory}

object AkkaActorSystem{

  var actorSystem:ActorSystem =_

  val config: Config = ConfigFactory.load("application.conf")
  val debugString =
    """
      |akka.loglevel = "debug"
      """.stripMargin

  val withFallback: Config = ConfigFactory.parseString(debugString).withFallback(config)

  def main(args:Array[String])={
    AkkaActorSystem.actorSystem = ActorSystem("TestAkkaSystem", withFallback)
    println("Config:getConfig::"+ withFallback.getString("akka.loglevel"))


  }
}
