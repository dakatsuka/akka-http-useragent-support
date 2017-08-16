organization := "jp.dakatsuka"

name := "akka-http-useragent-support"

scalaVersion := "2.12.3"

crossScalaVersions := Seq("2.11.11", "2.12.3")

version in ThisBuild := "0.1.0-SNAPSHOT"

lazy val akkaHttpVersion = "10.0.9"

libraryDependencies ++= Seq(
  "is.tagomor.woothee" % "woothee-java"       % "1.7.0",
  "com.typesafe.akka"  %% "akka-http"         % akkaHttpVersion,
  "com.typesafe.akka"  %% "akka-http-testkit" % akkaHttpVersion % "test",
  "org.scalatest"      %% "scalatest"         % "3.0.3" % "test"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "utf-8",
  "-feature",
  "-language:existentials",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xcheckinit",
  "-Xfatal-warnings",
  "-Xfuture",
  "-Xlint",
  "-target:jvm-1.8"
)

enablePlugins(ScalafmtPlugin)

scalafmtOnCompile := true

scalafmtTestOnCompile := true

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8", "-Xlint")

publishMavenStyle := true

pomIncludeRepository := { _ =>
  false
}
