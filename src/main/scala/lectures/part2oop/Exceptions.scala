package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a NPE (NullPointerException)
  // throwing and catching exceptions

  // 1. ho to throw exceptions

  // val aWierdValue: String = throw new NullPointerException()

  // throwable classes extends the Throwable class.
  // Exceptions and Error are the major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will be executed NO MATTER WHAT
    // finally block is optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception

  /*
  1. Crash your program with an OutOFMemoryError
  2. Crash with SOError
  3. PocketCalculator
      - add(x,y)
      - multiply(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds IntMIN_VALUE
        - MathCalculationException for division by 0
  */

}
