package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


    // constructors
    // subclass has to compile with parameters as from superclass, to guarantee a correct implementation
    class Person(name: String, age: Int){

      def this(name: String) = this(name, 0)  // adding auxilary method, extended subclass will find superclass
    }
    class Adult(name: String, age: Int, idCard: String) extends Person(name)

    // overriding
    class Dog(override val creatureType: String) extends Animal{
    //  override val creatureType = "domestic"
      override def eat = {
        super.eat
        println("crunch, crunch")
      }
    //class Dog(dogType: String) extends Animal{
    //  override val creatureType: String = dogType   // overriding in class constructor or creating class,
                                                    // and overriding in a body of a class is the same thing

    }
    val dog = new Dog("K9")
    dog.eat
    println(dog.creatureType)


    // type substitution (broad: polymorphism)

    val unknownAnimal: Animal = new Dog("K9")
    unknownAnimal.eat

    //overRIDING (supplying different implementation in derived classes)
    // vs overLOADING (supplying multiple methods with different signatures, but with the same name in the same class)

    // super - is used when you want to reference a method or a field from parent class

    // preventing overrides
    // 1 - use final on member
    // 2 - use final on the entire class
    // 3 - seal the class = extend in THIS FILE only, but prevent extension in other files ( keyword: sealed)




}
