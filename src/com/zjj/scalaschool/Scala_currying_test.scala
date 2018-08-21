/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/8/21
  * <p>Version: 1.0
  */

// currying例子

object Scala_currying_test{

  def main(args: Array[String]): Unit = {

    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numbers.foldLeft(0)((m, n) => m + n)
    print(res) // 55

    val numbers1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberFunc = numbers1.foldLeft(List[Int]())_

    val squares = numberFunc((xs, x) => xs:+ x*x)
    print(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

    val cubes = numberFunc((xs, x) => xs:+ x*x*x)
    print(cubes.toString())  // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)
  }
}
