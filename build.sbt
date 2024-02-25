import sbt.Keys.fork

name := "tsu-scala"
version := "0.1"
scalaVersion := "2.12.8"

// Global
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
  "-Yno-adapted-args",
  "-Ypartial-unification",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused-import",
  "-Xfuture"
)

addCommandAlias( "check", "clean; compile; test:compile; test")

// Modules
lazy val root = (project in file("."))
  .aggregate(snippets, spark, testing, typelevel)

lazy val common = Seq(
  "com.typesafe"                %  "config"           % "1.4.3",
  "com.typesafe.scala-logging"  %% "scala-logging"    % "3.9.2",
  "ch.qos.logback"              %  "logback-classic"  % "1.1.3"
)

lazy val snippets = (project in file("snippets"))
  .settings(
    libraryDependencies ++= common ++ Seq(
      "com.beachape"            %% "enumeratum"       % "1.7.2",
      "org.scalatest"           %% "scalatest"        % "3.2.15"
    )
  )

lazy val spark = (project in file("spark"))
  .settings(
    libraryDependencies ++= common ++ Seq(
      "org.apache.spark"        %% "spark-core"       % "2.4.8"
    )
  )

lazy val typelevel = (project in file("typelevel"))
  .settings(
    libraryDependencies ++= common ++ Seq(
      "org.scalatest"           %% "scalatest"        % "3.2.15",
      "org.typelevel"           %% "cats-core"        % "2.0.0",
      "org.typelevel"           %% "cats-effect"      % "2.0.0"
    )
  )

lazy val testing = (project in file("testing"))
  .settings(
    libraryDependencies ++= common ++ Seq (
      "org.scalatest" %% "scalatest" % "3.2.15"
    )
  )