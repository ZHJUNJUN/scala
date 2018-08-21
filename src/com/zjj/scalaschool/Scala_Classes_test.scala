import com.zjj.scalaschool.{Point1, PointWithPrivate, User}

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
object Scala_Classes_test{
  def main(args: Array[String]): Unit = {
    val user1 = new User

    // The keyword new is used to create an instance of the class.
    // User has a default constructor which takes no arguments because no constructor was defined.
    // However, you’ll often want a constructor and class body.
    // Here is an example class definition for a point:
    val point1 = new Point1(2, 3)
    point1.x  // 2
    println(point1)  // prints (2, 3)

    val origin = new Point1  // x and y are both set to 0
    val point2 = new Point1(1)
    println(point2.x)  // prints 1

    val point3 = new Point1(y=2)
    println(point3.y)  // prints 2

    val point4 = new PointWithPrivate
    point4.x = 99
    point4.y = 101 // prints the warning
  }
}