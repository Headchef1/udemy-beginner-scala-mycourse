package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a NPE (NullPointerException)
  // throwing and catching exceptions

  // 1. ho to throw exceptions

  // val aWierdValue: String = throw new NullPointerException()
  //                                  this ^^^^ one instantiates a class, that's why "new"

  // throwable classes extends the Throwable class.
  // Exceptions and Error are the major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  /*
  try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime Exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }
  */

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

  // throw exception


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

  // OOM
  // val array = Array.ofDim(Int.MaxValue)

  // SO
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y:Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y:Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result < 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result < 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int)= {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.divide(2, 0))

}
