val projectSettings = Map[String, String](
  "scalaVersion" -> "2.12.6",
  "organization" -> "com.example",
  "name" -> "perturbator",
  "version" -> "0.0.1-SNAPSHOT"
)

lazy val commonSettings = Seq(
  version := projectSettings("version"),
  scalaVersion := projectSettings("scalaVersion"),
  organization := projectSettings("organization"),
  name := projectSettings("name")
)

val deps = Seq(
  "com.typesafe" % "config" % "1.3.3"
)

val testDeps = Seq(
  "org.scalatest"     %% "scalatest" % "3.0.5" % "test",
  "com.jayway.restassured" % "rest-assured" % "2.9.0" % "test"
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(libraryDependencies ++= deps ++ testDeps)
  .settings(coverageEnabled := true)
  .settings(coverageMinimum := 100)
  .settings(coverageFailOnMinimum := true)
  .settings((scalastyleConfig in Test) := baseDirectory.value / "project/scalastyle_config.xml")
  .settings((scalastyleConfig in Compile) := baseDirectory.value / "project/scalastyle_config.xml")
  .settings(assemblyJarName in assembly := s"${projectSettings("name")}.jar")

libraryDependencies ++= deps ++ testDeps