package com.zjj.scalaschool


//
object HelloWorld {
  // 模式匹配
  // 匹配所有
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }

  // main
  // Scala程序从main()方法开始处理，这是每一个Scala程序的强制程序入口部分
  def main(args: Array[String]): Unit = {
    // match any
    println(bigger(4.0))
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