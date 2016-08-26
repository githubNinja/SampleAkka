package akka.persistence

import akka.actor.Props
import akka.actors.{Event, State}
import akka.persistence.streamDetails.{Increment, StreamId}
import com.typesafe.config.Config

package object streamDetails {
  type StreamId = String
  type Increment = Long
}


case class SaveSnapShotInitialize()
case class StreamEvent(streamName: String, streamId: String, incrementId: Option[Increment], streamActive: Boolean)

case class StreamState(streamId: String = "",streamName: String = "", streamArrivalTimeStamp: Long = 0L, streamActive: Boolean = false,
                       mapValue:Map[String, String] = Map.empty) extends State {
  def setStreamState( streamIdValue: String, incrementIdVal: Option[Increment], streamNameValue: String, streamActiveVal: Boolean, mapValues:Map[String, String]) =
    copy(streamIdValue , streamName = streamNameValue, streamArrivalTimeStamp = streamArrivalTimeStamp, streamActive = streamActiveVal,
      mapValue ++ Map( streamIdValue -> streamNameValue))
}

case class ReceivedEvent(streamName: String, streamId: StreamId, incrementId: Option[Increment], streamActive: Boolean, streamState: Map[String, String]) extends Event


object MyPersistenceActor {
  def apply(config: Config): Props = Props.create(classOf[MyPersistenceActor], config)
}


class MyPersistenceActor(config: Config) extends PersistentActor with State {
  override def persistenceId: String = s"MyPersistenceActor-${self.path.name}"

  var state: StreamState = StreamState()

  override def receive: Receive = handleOtherMessages orElse handleEvents

  var streamStateMap: Map[String, String] = Map.empty

  def updateState(event: Event): Unit = {
    event match {
      case ReceivedEvent(streamName, streamId, incrementId, streamStatus, streamState) =>
        println(s"Received Event Next Updating the State for StreamId ::${streamId} ")
        state = state setStreamState(streamId, incrementId, streamName,streamStatus, streamState)
        streamStateMap = state.mapValue
        println(s"state is ${state}")

    }
  }

  def handleOtherMessages: Receive = {
    case msg@SaveSnapShotInitialize() =>
      println("Save SnapShot Triggered !!!")
      saveSnapshot(state)
  }

  def handleEvents: Receive = {
    case StreamEvent(streamName, streamId, incrementId, streamActive) =>
      println("Received Stream Event !!" + streamId + "streamName::" + streamName + "::IncremenId::" + incrementId)
      super.persist(ReceivedEvent(streamName, streamId, incrementId, streamActive,
        Map(streamId -> streamName))) {
        event =>
          updateState(event)
          context.system.eventStream.publish(event)
      }
  }

  override def receiveRecover: Receive = {
    case RecoveryCompleted => println("Recovery Completed Invoked !!")

    case event: Event =>
      println("receiveRecover !! Event Msg Received !!")
      updateState(event)

    case SnapshotOffer(_, snapshot: StreamState) =>
      state = snapshot
      println(s"snapShot Offer !! ${snapshot} and state is ${state}")

  }

  override def receiveCommand: Receive = {
    case msg: Any =>
      println("Invoked receiveCommand !!" + msg)
  }
}
