/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/8/21
  * <p>Version: 1.0
  */
abstract class A {
  val message : String
}
class B extends A {
  val message = "I'm an instance of class B"
}
trait C extends A {
  def loudMessage = message.toUpperCase()
}

// Class D has a superclass B and a mixin C.
// Classes can only have one superclass but many mixins (using the keywords extends and
// with respectively).
// The mixins and the superclass may hav)e the same supertype.
class D extends  B with C

// The class has an abstract type T and the standard iterator methods.
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}

// The class has an abstract type T and the standard iterator methods.
// Next, we’ll implement a concrete class (all abstract members T, hasNext, and next have implementations):
class StringIterator(s : String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length
  def next() = {
    val ch = s charAt i
    i += 1
    ch
  }
}

// This trait implements foreach by continually calling the provided function f:
// T => Unit on the next element (next()) as long as there are further elements (while (hasNext)). Because RichIterator is a trait, it doesn’t need to implement the abstract members of AbsIterator.

// Now let’s create a trait which also extends AbsIterator.
trait RichIterator extends AbsIterator{
  def foreach(f : T=> Unit) : Unit = {
    while(hasNext) f(next())
  }
}

// We would like to combine the functionality of StringIterator and RichIterator into a single class.
// The new class RichStringIter has StringIterator as a superclass and RichIterator as a mixin.
class RichStringIter extends StringIterator("Scala") with RichIterator


object Scala_MIXINS_test{
  def main(args: Array[String]): Unit = {
      val d  = new D
      println(d.message)
      println(d.loudMessage)

     // test
     val richStringIter = new RichStringIter
     richStringIter foreach println
  }
}
