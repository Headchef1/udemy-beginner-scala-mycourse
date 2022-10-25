package lectures.pat4pm

import scala.util.Random

object PaternMatching extends App {

  // switch on steroids
  val random = new Random
  val x= random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCRAD
  }

  println(x)
  println(description)

}
