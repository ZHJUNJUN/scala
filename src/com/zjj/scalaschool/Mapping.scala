import scala.util.matching.Regex

/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/9/30
  * <p>Version: 1.0
  */

object Mapping{

  def d(x: (Int) => Int) = x(2)

  def c(x: (Int, Int) => Int) = x(2, 3);

  val b = (x: Int) => (y: Int) => x + y;

  val scores = Map("Alice" -> 10,"Bob" -> 3,"Cindy" -> 8)

  //可变的映射，
  val scores1 = scala.collection.mutable.Map("Alice" -> 10,"Bob" -> 3,"Cindy" -> 8)

  // 空的映射
  val scores2 = new scala.collection.mutable.HashMap[String,Int]

  def main(args: Array[String]): Unit = {
      // x => x * 2
      println(d((x :Int) => x * 3));

      // x , y => x * y * 3
      println(c((x: Int, y: Int) => x * y * 3));

      // 在加深一点难度,大家看看这个函数,b第一次调用返回函数(y: Int) => x + y,在一次调用返回结果。
      // 相关文章参考快学scala 第十二章 高阶函数 145页
      println(b.apply(5).apply(6));


      println(scores)

      println(scores1)

      println(scores2)

      println("Alice" -> 10)

    }
}