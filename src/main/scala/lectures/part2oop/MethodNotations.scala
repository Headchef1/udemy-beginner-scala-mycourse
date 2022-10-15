package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, age: Int) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def +(nickName: String): String = s"${this.name} $nickName"
    //def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)   // what should I have done
    def unary_+ : Int = age + 1
    //def unary_+ : Person = new Person(name, favoriteMovie, age + 1) // what should I have done
    def learns(thing: String) = s"$name learns $thing" // what should I have done
    def learnsScala= this learns "Scala" // what should I have done
    def apply(times: Int): String = s"$name watched $favoriteMovie $times times"
  }

  val mary = new Person("Mary", "Inception", 30)
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar). Can take only 1 parameter.

  //"operators" in scala. They are methods, thats why we do not take them literally but in quotes.
  val tom = new Person("Tom", "Fight Club", 35)
  println(tom + mary)
  println(mary.+(tom))

  println(mary.apply(2))
  println(mary(10))
  // println((+mary).age )
  println(mary learnsScala)

  // println((mary + "the Rockstar")())

  println(mary + "is a 'Rock Start'")

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?

  // prefix notation
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-   // the same as previous
  // unary_ prefix only works with - + ~ !

  println(!mary) // both expressions are equivalent
  println(mary.unary_!)
  println(+mary)

  // postfix notation. Is available to methods who do not receive parameters.
  println(mary.isAlive)
  println(mary isAlive)

  //apply. Mehod has to be with aprentesis -> apply()
  println(mary.apply())
  println(mary()) // equivalent to .apply

  /*
    1. overload the + operator which receives a String and will return new person with a nickname
        mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age tщ the Person class with default 0 value, if we want
        Add a unary + operator => new person with the afe + 1
        +mary = > mary with the age incrementer

    3. Add a "learns" method in the Person class, receives a String parameter => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala"
        Use it in postfix notation.

    4. Overload the apply method to receive a number and returns a String
        mary.apply(2) => "Mary watched Inception 2 times"
  */



}
