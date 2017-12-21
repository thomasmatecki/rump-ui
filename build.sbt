import java.io.File

name := """rump-ui"""
organization := "com.rump"

version := "1.0-SNAPSHOT"

val compileClojure = taskKey[Unit]("Compile Clojure Sources")

lazy val root = (project in file(".")).enablePlugins(PlayScala) settings (
  /**
    * Compile Clojure Source Code
    */


  compileClojure := {

    val s: TaskStreams = streams.value

    val clojureSources: Seq[File] = ((sourceDirectory in Compile).value ** "*.clj").get
    val classpath: Seq[File] = update.value.select(configurationFilter(name = "*")) ++ Seq((classDirectory in Compile).value)
    val stubDirectory: File = (sourceManaged in Compile).value
    val destinationDirectory: File = (classDirectory in Compile).value

    s.log.info(s"Compiling Clojure Source Files: ${clojureSources}")


    new ClojureC(classpath, stubDirectory, destinationDirectory, s.log).compile(clojureSources)

  })

scalaVersion := "2.12.3"
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test


libraryDependencies ++= Seq(
  "org.clojure" % "clojure" % "1.8.0",
  "com.datomic" % "clj-client" % "0.8.606",
  "org.clojure" % "core.async" % "0.3.465")


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.rump.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.rump.binders._"
