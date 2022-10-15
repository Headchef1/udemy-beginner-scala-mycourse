package lectures.part2oop

import playground.{PrinceCharming, Cinderella as Princess}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess    // playground.Cinderella = fully quialified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  // sayHello
  // println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use Fully Qualified name
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exceptions
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
