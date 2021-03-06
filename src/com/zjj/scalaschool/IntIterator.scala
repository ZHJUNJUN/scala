package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */

// Use the extends keyword to extend a trait.
// Then implement any abstract members of the trait using the override keyword

class IntIterator(to : Int) extends Iterator[Int]{
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if(hasNext){
      val t = current
      current += 1
      t
    }else 0
  }
}
