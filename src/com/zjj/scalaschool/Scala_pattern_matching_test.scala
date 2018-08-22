import scala.util.Random

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/8/21
  * <p>Version: 1.0
  */
/**
  * Pattern matching is a mechanism for checking a value against a pattern.
  * A successful match can also deconstruct a value into its constituent parts.
  * It is a more powerful version of the switch statement in Java and
  * it can likewise be used in place of a series of if/else statements.
  */

// Matching on case classes
abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

abstract class Device

case class Phone(model:String) extends Device {
  def screenOff = "Turning screen off"
}

case class Computer(model:String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

// Traits and classes can be marked sealed which means all subtypes must be declared in the same file.
// This assures that all subtypes are known.
sealed abstract class Furniture

case class Couch() extends Furniture
case class Chair() extends Furniture


object Scala_pattern_matching_test{

  // This is useful for pattern matching because we don’t need a “catch all” case.
  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }

  /**
    * Notification is an abstract super class which has three concrete Notification types implemented with case classes Email, SMS, and VoiceRecording.
    * Now we can do pattern matching on these case classes:
    * @param device
    * @return
    */
  // def goIdle has a different behavior depending on the type of Device.
  // This is useful when the case needs to call a method on the pattern.
  // It is a convention to use the first letter of the type as the case identifier (p and c in this case).
  def goIdle(device:Device) = device match {
    case p : Phone => p.screenOff
    case d : Computer => d.screenSaverOn
  }

  // The function showNotification takes as a parameter the abstract type Notification and matches on the type of Notification (i.e. it figures out whether it’s an Email, SMS, or VoiceRecording).
  // In the case Email(email, title, _) the fields email and title are used in the return value but the body field is ignored with _.
  def showNotification(notification: Notification): String ={
    notification match  {
      case Email(email,title,_) =>
        s"You got an email from $email with title: $title"
      case SMS(number,message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }

  // Pattern guards
  // Pattern guards are simply boolean expressions which are used to make cases more specific.
  // Just add if <boolean expression> after the pattern.
  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]):String = {
    notification match {
      case Email(email,_,_) if importantPeopleInfo.contains(email) =>
        "You got an email from special someone!"
      case SMS(number,_) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
         showNotification(other)
    }
  }

  // Match expressions have a value.
  def matchTest(x : Int):String = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def main(args: Array[String]): Unit = {
    // The val x above is a random integer between 0 and 10.
    // x becomes the left operand of the match operator and on the right is an expression with four cases.
    // The last case _ is a “catch all” case for any number greater than 2.
    // Cases are also called alternatives.
    val x: Int = Random.nextInt(10)

    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }

    println(matchTest(3))  // many
    println(matchTest(1))  // one

    // test case class match
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

    println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
    val someVoiceRecording1 = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    // In the case Email(email, _, _)
    // if importantPeopleInfo.contains(email),
    // the pattern is matched only if the email is in the list of important people.
    println(showImportantNotification(someSms, importantPeopleInfo))
    println(showImportantNotification(someVoiceRecording1, importantPeopleInfo))
    println(showImportantNotification(importantEmail, importantPeopleInfo))
    println(showImportantNotification(importantSms, importantPeopleInfo))

    val p = Phone("xiaomi")
    val c = Computer("tnt");
    println(goIdle(p))
    println(goIdle(c))
  }
}
