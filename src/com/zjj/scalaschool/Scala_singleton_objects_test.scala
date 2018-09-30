/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/9/30
  * <p>Version: 1.0
  */
import Scala_singleton_objects.info
import com.zjj.scalaschool.Circle

/***
  *
  * @param name
  * @param daysToComplate
  *
  * The info method is visible because of the import statement, import logging.Logger.info.
  * Imports require a “stable path” to the imported symbol, and an object is a stable path.
  * Note: If an object is not top-level but is nested in another class or object, then the object is “path-dependent” like any other member.
  * This means that given two kinds of beverages, class Milk and class OrangeJuice, a class member object NutritionInfo “depends” on the enclosing instance, either milk or orange juice.
  * milk.NutritionInfo is entirely distinct from oj.NutritionInfo.
  *
  */

class Project(name: String,daysToComplate: Int)

class Test{
  val project1 = new Project("TPS Reports", 1)
  val project2 = new Project("Website redesign", 5)
  info("Created projects")  // Prints "INFO: Created projects"
}

object Scala_singleton_objects_test {
  val circle1 = new Circle(5.0);
  print(circle1.area)
}
