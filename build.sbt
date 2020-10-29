//import sbtsonar.SonarPlugin.autoImport._

lazy val root: Project = (project in file("."))
  .settings(
    organization := "com.chatwork",
    name := "scala-quiz",
    version := "1.0",
    scalaVersion := "2.13.2",
    scalacOptions ++= Seq(
        "-encoding",
        "UTF-8",
        "-feature",
        "-unchecked",
        "-deprecation"
      ),
    libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.1.1" % Test
      ),
    coverageEnabled := true
//    sonarUseExternalConfig := true,
//    aggregate in sonarScan := false
  )