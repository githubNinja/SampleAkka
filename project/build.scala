import sbt.{ProjectReference, Build}
import sbt.Keys._
import sbt._

object SampleAkkaBuild extends Build {

/*  import BuildSettings._
  import Dependencies._

  // prompt to show current project
  override lazy val settings = super.settings :+ {
    shellPrompt := ShellPrompt.buildShellPrompt
  }

  lazy val allModules: Seq[ProjectReference] = Seq(streamIngestion, messageHandler, mdpEndpoints, common, mdpEventBus, mdpWeb)

  lazy val allModuleDependencies = allModules.map {
    module => module % "runtime->runtime;compile->compile"
  }*/

}