package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
class CustomizableGreeter(prefix: String, postfix: String) extends GreeterTrait{
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}
