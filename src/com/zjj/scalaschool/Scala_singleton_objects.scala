/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/9/29
  * <p>Version: 1.0
  */

object Scala_singleton_objects {
  /**
    * An object is a class that has exactly one instance. It is created lazily when it is referenced, like a lazy val.
    * As a top-level value, an object is a singleton.
    * As a member of an enclosing class or as a local value, it behaves exactly like a lazy val.
    *
    */
  def info(message: String) = println(s"INFO: $message")

}