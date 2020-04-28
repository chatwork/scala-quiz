lazy val root: Project = (project in file("."))
  .settings(
    organization  := "com.chatwork",
    name          := "scala-quiz",
    version       := "1.0",
    scalaVersion  := "2.11.4",
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation"
    ),
    libraryDependencies ++= Seq(
      "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
    )
  )
