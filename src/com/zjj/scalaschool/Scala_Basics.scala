import com.zjj.scalaschool.{CustomizableGreeter, DefaultGreeter, Greeter, Point}

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
// Main method
object Scala_Basics {

  // 测试demo
  def main(args: Array[String]): Unit = {
    println("Hello, Scala developer!")

    // Expressions
    println(1) // 1
    println(1 + 1) // 2
    println("Hello!") // Hello!
    println("Hello," + " world!") // Hello, world!

    // Values
    // You can name results of expressions with the val keyword.
    val x = 1 + 1
    println(x) // 2
    // Values cannot be re-assigned.
    // val x = 1 + 1
    // x = 3 // This does not compile.

    // Variables
    var y = 1 + 1
    y = 3 // This compiles because "x" is declared with the "var" keyword.
    println(y * y) // 9

    // Blocks
    // You can combine expressions by surrounding them with {}. We call this a block.
    // The result of the last expression in the block is the result of the overall block, too.
    println({
      val x = 1 + 1
      x + 1
    }) // 3

    // Functions
    // (x: Int) => x + 1
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2
    // Functions may take multiple parameters.
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3
    // Or it can take no parameters.
    val getTheAnswer = () => 42
    println(getTheAnswer()) // 42

    //Methods
    def add1(x: Int, y: Int): Int = x + y
    println(add1(1, 2)) // 3
    // Methods can take multiple parameter lists.
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(addThenMultiply(1, 2)(3)) // 9
    // Or no parameter lists at all.
    def name: String = System.getProperty("user.name")
    println("Hello, " + name + "!")
    // Methods can have multi-line expressions as well.
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }

    // Classes
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Scala developer") // Hello, Scala developer!

    // Case Classes
    // You can instantiate case classes without new keyword.
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)
    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    }
    // Point(1,2) and Point(1,2) are the same.
    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    }
    // Point(1,2) and Point(2,2) are different.

    // Objects
    // Objects are single instances of their own definitions. You can think of them as singletons of their own classes.
    // You can define objects with the object keyword.
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }
    // You can access an object by referring to its name.
    val newId: Int = IdFactory.create()
    println(newId) // 1
    val newerId: Int = IdFactory.create()
    println(newerId) // 2
    val greeter1 = new DefaultGreeter()
    greeter1.greet("Scala developer")
    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer") // How are you, Scala developer?
  }
}
