import com.zjj.scalaschool.{Cat, Dog, IntIterator, Pet}

import scala.collection.mutable.ArrayBuffer

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/7/27
  * <p>Version: 1.0
  */
object Scala_trait_test {
  def main(args: Array[String]): Unit = {
    /**
      * Extending the trait Iterator[A] requires a type A and implementations of the methods hasNext and next.
      */
    // Using traits
    // This IntIterator class takes a parameter to as an upper bound.
    // It extends Iterator[Int] which means that the next method must return an Int.
    val iterator = new IntIterator(10)
    println(iterator.next())  // returns 0
    println(iterator.next())    // returns 1
    println(iterator.next())  // returns 0
    println(iterator.next())    // returns 1
    println(iterator.next())  // returns 0
    println(iterator.next())    // returns 1
    println(iterator.next())  // returns 0
    println(iterator.next())    // returns 1

    // Subtyping
    // The trait Pet has an abstract field name which gets implemented by Cat and Dog in their constructors.
    // On the last line, we call pet.name which must be implemented in any subtype of the trait Pet.
    val dog = new Dog("Harry")
    val cat = new Cat("Sally")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name))  // Prints Harry Sally

    var split = (line : String) => (line.split(" ")(0), 1)
    val logs = List(
                  "46.202.124.63 - - [2015-11-26 09:54:27] \"GET /view.php HTTP/1.1\" 200 0 \"http://www.google.cn/search?q=hadoop\" \"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)\" \"-\"",
                  "46.202.124.64 - - [2015-11-26 09:54:27] \"GET /view.php HTTP/1.1\" 200 0 \"http://www.google.cn/search?q=hadoop\" \"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)\" \"-\"",
                  "46.202.124.65 - - [2015-11-26 09:54:27] \"GET /view.php HTTP/1.1\" 200 0 \"http://www.google.cn/search?q=hadoop\" \"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)\" \"-\"",
                  "46.202.124.66 - - [2015-11-26 09:54:27] \"GET /view.php HTTP/1.1\" 200 0 \"http://www.google.cn/search?q=hadoop\" \"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)\" \"-\""
    );
    // map 和 foreach的不同
    val result = logs.map(split)
    val result1 = logs.foreach(split)
    println(result)
    println(result1)
  }
}

