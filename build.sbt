import java.io.PrintWriter
import java.util.UUID

lazy val root = (project in file("."))
  .settings(
    name := "sbt-sandbox",
    organization := "com.pigumer",
    scalaVersion := "2.12.6",
    version := "0.1.0-SNAPSHOT"
  )

initialize.:= {
  file("src/main/resources/uuid.txt").delete()
}

resourceGenerators in Compile += Def.task {
  val uuid = UUID.randomUUID().toString
  val s = streams.value
  s.log.info(uuid)
  val path = "src/main/resources/uuid.txt"
  val writer = new PrintWriter(path)
  try {
    writer.print(uuid)
  } finally {
    writer.close()
  }
  Seq(file(path))
}.taskValue