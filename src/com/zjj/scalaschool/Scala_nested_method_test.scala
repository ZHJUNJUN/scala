/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/8/21
  * <p>Version: 1.0
  */
// In Scala it is possible to nest method definitions.
// The following object provides a factorial method for computing the factorial of a given number:
object Scala_nested_method_test{
  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }
  def main(args: Array[String]): Unit = {
    println("Factorial of 2: " + factorial(2))
    println("Factorial of 3: " + factorial(3))
  }
}
