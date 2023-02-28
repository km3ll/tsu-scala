name := "tsu-scala"
version := "0.1"
scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
    "org.typelevel"               %% "cats-core"       % "2.0.0",
    "org.typelevel"               %% "cats-effect"     % "2.0.0",
    "org.apache.commons"          %  "commons-lang3"   % "3.3.2",
    "com.typesafe"                %  "config"          % "1.3.2",
    "ch.qos.logback"              %  "logback-classic" % "1.1.3",
    "io.monix"                    %% "monix"           % "2.3.3",
    "org.scalacheck"              %% "scalacheck"      % "1.14.0",
    "org.scalatest"               %% "scalatest"       % "3.2.15",
    "com.typesafe.scala-logging"  %% "scala-logging"   % "3.9.2",
    "com.github.pureconfig"       %% "pureconfig"      % "0.17.1",
    "com.beachape"                %% "enumeratum"      % "1.7.2"
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
  "-Yno-adapted-args",
  "-Ypartial-unification",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused-import",
  "-Xfuture"
)

addCommandAlias( "check", "clean; compile; test:compile; test")