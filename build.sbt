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
  "-explaintypes",
  "-feature",
  "-language:existentials",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xcheckinit",
  "-Xfatal-warnings",
  "-Xfuture",
  "-Xlint:adapted-args",
  "-Xlint:by-name-right-associative",
  "-Xlint:constant",
  "-Xlint:delayedinit-select",
  "-Xlint:doc-detached",
  "-Xlint:inaccessible",
  "-Xlint:infer-any",
  "-Xlint:missing-interpolator",
  "-Xlint:nullary-override",
  "-Xlint:nullary-unit",
  "-Xlint:option-implicit",
  "-Xlint:package-object-classes",
  "-Xlint:poly-implicit-overload",
  "-Xlint:private-shadow",
  "-Xlint:stars-align",
  "-Xlint:type-parameter-shadow",
  "-Xlint:unsound-match",
  "-Yno-adapted-args",
  "-Ypartial-unification",
  "-Ywarn-dead-code",
  "-Ywarn-extra-implicit",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-unused:implicits",
  "-Ywarn-unused:imports",
  "-Ywarn-unused:patvars",
  "-target:jvm-1.8"
)

scalacOptions in (Compile, console) -= "-Ywarn-unused:imports"

enablePlugins(ScalafmtPlugin)

scalafmtOnCompile := true

scalafmtTestOnCompile := true

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8", "-Xlint")

publishMavenStyle := true

pomIncludeRepository := { _ =>
  false
}
