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
  .aggregate(base, snippets, typelevel)


lazy val snippets = (project in file("1_snippets"))
  .settings(
    libraryDependencies ++= Seq(
      "ch.qos.logback"              %  "logback-classic"  % "1.1.3",
      "com.beachape"                %% "enumeratum"       % "1.7.2",
      "com.typesafe"                %  "config"           % "1.3.2",
      "com.typesafe.scala-logging"  %% "scala-logging"    % "3.9.2",
      "org.scalatest"               %% "scalatest"        % "3.2.15"
    )
  )

lazy val typelevel = (project in file("2_typelevel"))
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel"   %% "cats-core"    % "2.0.0",
      "org.typelevel"   %% "cats-effect"  % "2.0.0",
      "org.scalatest"   %% "scalatest"    % "3.2.15"
    )
  )

lazy val base = (project in file("testing"))
  .settings(
    libraryDependencies ++= Seq(
      "ch.qos.logback"              %  "logback-classic"  % "1.1.3",
      "com.typesafe"                %  "config"           % "1.3.2",
      "com.typesafe.scala-logging"  %% "scala-logging"    % "3.9.2",
      "org.scalatest"               %% "scalatest"        % "3.2.15"
    )
  )