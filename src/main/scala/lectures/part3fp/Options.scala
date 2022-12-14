package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Options were designed to dael with unsafe APIs. Below is how we work with unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(null)   // WRONG. Some should have a valid value
  val result = Option(unsafeMethod()) // Some or None. We do not check nulls, Option does it for us.
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // on other hand I am DESIGNING unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackUpMethod(): Option[String] = Some("A valid result")
  val betterChainResult = betterUnsafeMethod() orElse betterBackUpMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)  // UNSAFE - DO NOT USE THIS

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
    Exercise
  */
  val config: Map[String, String] = Map(
    // contains values fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)

    return null
  */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /*
    if (c != null)
      return c.connect
    return null
  */

  val connectionStatus = connection.map(c => c.connect)
  // if (connectionStatus == null) println(None) else print (Some(connectionStatus.get))
  println(connectionStatus)
  /*
      if (status != null)
        println(status)
     */
  connectionStatus.foreach(println)

  // chained method solution. Chained calls
  config.get("host")
      .flatMap(host => config.get("port")
        .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
      .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
}
