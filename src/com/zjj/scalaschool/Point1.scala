package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
class Point1 (var x : Int = 0 ,var y: Int = 0 ){
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = {
    s"($x,$y)"
  }

}
