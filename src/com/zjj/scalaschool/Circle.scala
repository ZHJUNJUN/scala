package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/9/30
  * <p>Version: 1.0
  */
// The class Circle has a member area which is specific to each instance,
// and the singleton object Circle has a method calculateArea which is available to every instance.
case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  private def calculateArea(redius: Double) : Double = scala.math.Pi * scala.math.pow(redius, 2.0)

  def main(args: Array[String]): Unit = {
    val circle = new Circle(5.0);
    print(circle.area)
  }
}

// The companion object can also contain factory methods:
class Email(val username: String, val domainName: String)

/**
  *  The object Email contains a factory fromString which creates an Email instance from a String.
  *  We return it as an Option[Email] in case of parsing errors.
  *  Note: If a class or object has a companion, both must be defined in the same file.
  *  To define companions in the REPL, either define them on the same line or enter :paste mode.
  */
object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }

  val scalaCenterEmail = Email.fromString("ycuzjj@163.com")
  def main(args: Array[String]): Unit = {
    scalaCenterEmail match {
      case Some(email) => println(
        s"""Registered an email
           |Username: ${email.username}
           |Domain name: ${email.domainName}
     """)
      case None => println("Error: could not parse email")
    }
  }
}
