ThisBuild / scalaVersion     := "2.12.19"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "tsu.pod.scala"

lazy val root = (project in file("."))
  .settings(
    name := "learn-basics",
    libraryDependencies ++= Seq(
      "io.circe"                    %% "circe-core"       % "0.14.1",
      "io.circe"                    %% "circe-generic"    % "0.14.1",
      "io.circe"                    %% "circe-parser"     % "0.14.1",
      "com.typesafe"                %  "config"           % "1.4.3",
      "ch.qos.logback"              %  "logback-classic"  % "1.5.9",
      "com.typesafe.scala-logging"  %% "scala-logging"    % "3.9.5",
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