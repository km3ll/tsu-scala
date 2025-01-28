ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "tsu.pod.scala"

lazy val root = (project in file("."))
  .settings(
    name := "learn-basics",
    libraryDependencies ++= Seq(
      "com.typesafe"                %  "config"           % "1.4.3",
      "com.typesafe.scala-logging"  %% "scala-logging"    % "3.9.5",
      "ch.qos.logback"              %  "logback-classic"  % "1.5.9",
      // Testing
      "org.scalacheck"              %% "scalacheck"       % "1.14.1" % "test",
      "org.scalatest"               %% "scalatest"        % "3.2.19" % "test"
    )
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:experimental.macros",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard"
)

addCommandAlias( name = "check", value = "clean; compile; test:compile; test")

Test / parallelExecution := true