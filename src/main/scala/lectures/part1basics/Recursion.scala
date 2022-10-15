package lectures.part1basics

import scala.annotation.tailrec
import math.Fractional.Implicits.infixFractionalOps
import math.Integral.Implicits.infixIntegralOps
import math.Numeric.Implicits.infixNumericOps

object Recursion extends App {
  def factorial (n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorila of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))
  // println(factorial(50000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) // TAIL RECURSION = use recursive call as a last expression

    factHelper(n, 1)
  }



  /*
   anotherFactorial(1) = factHelper(10, 1)
   = factHelper(9, 10 * 1)
   = factHelper(8, 9 * 10 * 1)
   = factHelper(7, 8 * 9 * 10 * 1)
   = ...
   = factHelper(2, 3 * 4 * ... *10 * 1)
   = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
   = 1 * 2 * 3 * ... * 10
  */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive.
  */

  @tailrec
  def concatString(word: String, num: Int, acc: String): String =
    if (num <= 0) acc
    else concatString(word, num - 1, word + acc)

  println(concatString("Hello", 5, ""))


  def isPrime(n: Int): Boolean ={
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))


}
