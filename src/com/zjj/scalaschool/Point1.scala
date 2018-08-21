package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
// This Point class has four members:
// the variables x and y and the methods move and toString.
// Unlike many other languages, the primary constructor is in the class signature (var x: Int, var y: Int).
// The move method takes two integer arguments and returns the Unit value (), which carries no information.
// This corresponds roughly with void in Java-like languages.
// toString, on the other hand, does not take any arguments but returns a String value.
// Since toString overrides toString from AnyRef, it is tagged with the override keyword.

class Point1 (var x : Int = 0 ,var y: Int = 0 ){
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = {
    s"($x,$y)"
  }

}
