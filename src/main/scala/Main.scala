import java.nio.charset.StandardCharsets

object Main extends App {
  val is = Thread.currentThread.getContextClassLoader.getResourceAsStream("uuid.txt")
  try {
    val s = Stream.continually(is.read).takeWhile(_ != -1).map(_.toByte).toArray
    println(new String(s, StandardCharsets.UTF_8))
  } finally {
    is.close()
  }
}
