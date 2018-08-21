package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
class Greeter (prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}
