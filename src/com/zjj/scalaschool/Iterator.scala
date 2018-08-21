package com.zjj.scalaschool

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
// Traits become especially useful as generic types and with abstract methods.
trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}
