import ReleaseTransformations._

organization := "com.github.dakatsuka"

name := "akka-http-useragent-support"

scalaVersion := "2.12.3"

crossScalaVersions := Seq("2.11.11", "2.12.3")

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

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/dakatsuka/akka-http-useragent-support"))

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ =>
  false
}

releaseCrossBuild := true

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots
  else Opts.resolver.sonatypeStaging
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/dakatsuka/akka-http-useragent-support"),
    "scm:git@github.com:dakatsuka/akka-http-useragent-support.git"
  )
)

developers := List(
  Developer(
    id = "dakatsuka",
    name = "Dai Akatsuka",
    email = "d.akatsuka@gmail.com",
    url = url("https://github.com/dakatsuka")
  )
)

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(action = Command.process("publishSigned", _)),
  setNextVersion,
  commitNextVersion,
  ReleaseStep(action = Command.process("sonatypeRelease", _)),
  pushChanges
)
