/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/8/21
  * <p>Version: 1.0
  */

/**
  * Case classes are like regular classes with a few key differences which we will go over.
  * Case classes are good for modeling immutable data. In the next step of the tour,
  * we’ll see how they are useful in pattern matching.
  * @param ibsn
  */
case class Book(ibsn : String)

// When you create a case class with parameters, the parameters are public vals.
case class Message(sender: String, recipient:String ,body:String)

object Scala_caseclass_test{
  def main(args: Array[String]): Unit = {
    // Notice how the keyword new was not used to instantiate the Book case class.
    // This is because case classes have an apply method by default which takes care of object construction.
    val frankenstein = Book("978-0486282114")

    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
    println(message1.sender)  // prints guillaume@quebec.ca

    // You can’t reassign message1.sender because it is a val (i.e. immutable).
    // It is possible to use vars in case classes but this is discouraged.
    // message1.sender = "travis@washington.us"  // this line does not compile

    val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val messagesAreTheSame = message2 == message3  // true
    // Case classes are compared by structure and not by reference:
    // Even though message2 and message3 refer to different objects, the value of each object is equal.
    println(messagesAreTheSame)

    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5 = message4.copy()
    println(message5)
  }
}


