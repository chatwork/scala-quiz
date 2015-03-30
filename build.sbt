name := "sandbox"

version := "1.0"

scalaVersion := "2.11.4"

scalacOptions ++= Seq("-encoding", "UTF-8", "-feature", "-unchecked", "-deprecation")

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

scalariformSettings

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle
