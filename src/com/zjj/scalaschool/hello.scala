package com.zjj.scalaschool

object HelloWorld {

  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }

  // match any
  println(bigger(4.0))

  // main
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }

  // times
  val times = 1

  // case
  println(times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  })

}