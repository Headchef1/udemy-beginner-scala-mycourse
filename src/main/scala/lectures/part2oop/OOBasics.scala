package lectures.part2oop

object OOBasics extends App {

 val author = new Writer("Artur", "Makarov", 1990)
 // val imposter = new Writer("Artur", "Makarov", 1990)
 val novel = new Novel("Whisper of the wind", 2010, author)

 println(novel.authorAge)
 println(novel.isWrittenBy(author))

 val counter = new Counter
 counter.inc.print
 counter.inc.inc.inc.inc.print
 counter.inc(10).dec(2).print
}

class Writer(firstName: String, surname: String, val yearOfBirth: Int){
  def fullName: String = firstName + " " + surname

}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge: Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer) = author == this.author
  def copy(yearOfNewRelease: Int): Novel = new Novel(name, yearOfNewRelease, author)

}

class Counter(val count: Int = 0){
  def inc = {
    println("Incrementing")
    new Counter(count + 1)    // immutability
  }

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}







  /*


  val person = new Person("John", 26 )
  println(person.age)
  //person.greet("Artur")
  person.greet()

}
// constructor
class Person(name: String, val age: Int)  {   //class parameters are NOT FIELDS
  // body
  val x = 2

  println(1 + 3)

  // method
  //def greet (name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")
  // def greet(): Int = 42

  // multiple constructors or overloading constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

  /*
  Novel and a Writer Class
  Writer: first name, surname and year of birth
    - method fullname. Returns cancatination of furs name and surname

  Novel: name, year of release, author
    - method authorAge (age of the author at the year of release)
    - isWrittenBy (author)
    - copy (new year of release) - new instance of Novel
  */

  /*
  Counter class
    - receives and int value
    - method current count
    - method to increment/decrement counter by 1) = > new Counter
    - overload inc/dec to receive an amount
   */

  */





