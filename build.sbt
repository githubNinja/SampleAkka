import scalariform.formatter.preferences._

name := "SampleAkkaSBTProject"
version := "1.1"

//Use this version for the Akka Streams
scalaVersion := "2.11.7"

//Use this version for the other than Akka Streams
//scalaVersion := "2.10.4"

resolvers ++= Seq("repo" at "http://repo.typesafe.com/typesafe/releases/")

val akkaVersion = "2.3.10"
val sprayVersion = "1.3.2"
val reactiveStreams = "1.0.0"
val AkkaStreamVersion      = "1.0-RC1"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % "2.11.7",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  //"io.spray" %% "spray-can" % sprayVersion,
 // "io.spray" %% "spray-routing" % sprayVersion,
  //"io.spray" %% "spray-json" % "1.2.6",
  "org.scalatest" % "scalatest_2.11" % "2.1.7" % "test",
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "2.2.0",
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-contrib" % akkaVersion,
  "com.typesafe.akka" %% "akka-camel" % akkaVersion,
  "com.typesafe.akka" %% "akka-agent" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-experimental" % "1.0",
  "com.typesafe.akka" %% "akka-persistence-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-experimental" % AkkaStreamVersion,
  "com.typesafe.akka" %% "akka-http-scala-experimental" % AkkaStreamVersion,
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "net.databinder.dispatch" %% "dispatch-json4s-native" % "0.11.2",
  "com.google.protobuf" % "protobuf-java" % "2.5.0",
  "org.scalaz" %% "scalaz-core" % "7.1.0" ,
  "org.iq80.leveldb"            % "leveldb"          % "0.7" ,
  "org.fusesource.leveldbjni"   % "leveldbjni-all"   % "1.8")

////"og.reactivestreams" % "reactive-streams-spi" % "1.0.",
//"com.typesafe.akka" %% "akka-stream-experimental" % "1.0",