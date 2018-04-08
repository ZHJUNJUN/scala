package com.zjj.scalaschool

/**
  * Created by zjj on 18/4/4.
  */
object Fundamental {
  // 基本数据类型
  var hex = 0x5
  var hex2 = 0x00ffe
  val prog = 0xcafebabel
  val litter:Byte = 38
  val big = 1.222
  val a = 'A'
  val f = '\u0041'
  val hello = "hello"
  val longString = """welcome to beijing hello world"""
  val bool = true

  // Scala 的基本数据类型的字面量也支持方法（这点和 Java 不同，Scala 中所有的数值字面量也是对象），比如
  val testabs = (-2.7).abs
  // 这些方法其实是对于数据类型的 Rich 类型的方法， Rich 类型将在后面再做详细介绍。
  val testabs1 = -2.7 abs
  val testmax = 0 max 5
  val testrange = 4 to 6

  // 操作基本数据类型
  // Scala 提供了丰富的运算符用来操作前面介绍的基本数据类型。前面说过，这些运算符（操作符）实际为普通类方法的简化（或者称为美化）表示。比如 1+2 ，实际为 (1).+(2) ，也就是调用 Int 类型的 + 方法。
  val sumMore = (1).+(2)
  // + 符号是一个运算符，并且是一个中缀运算符。 在 Scala 中你可以定义任何方法为一操作符。 比如 String 的 IndexOf 方法也可以使用操作符的语法来书写
  val s = "hello , world"  // s: String = Hello World

  val index = s indexOf 'o'

  // 除了类似 + 的中缀运算符（操作符在两个操作符之间），还可以有前缀运算符和后缀运算符。
  // 顾名思义前缀运算符的操作符在操作数前面，比如 -7 前面的 - 。后缀运算符的运算符在操作数的后面，比如 7 toLong 中的 toLong 。
  // 前缀和后缀操作符都使用一个操作数，而中缀运算符使用前后两个操作数。Scala 在实现前缀和后缀操作符的方法，其方法名都以 unary_- 开头
  val unary = (2.0).unary_-

  // 如果你需要定义前缀方法，你只能使用 +、-、! 和 ～ 四个符号作为前缀操作符
  // 后缀操作符在不使用 . 和括号调用时不带任何参数。在 Scala 中，
  // 你可以省略掉没有参数的方法调用的空括号。按照惯例，如果你调用方法是为了利用方法的“副作用”，
  // 此时写上空括号，如果方法没有任何副作用（没有修改其它程序状态），你可以省略掉括号。
  val lowerCase = "HELLO" toLowerCase

  // 恒等比较
  def isEqual(x:Int,y:Int) = x == y
  def isEqual(x:Any,y:Any) = x == y

  // Scala 的 == 设计出自动适应变量类型的操作，对值类型来说，
  // 就是自然的（数学或布尔）相等。对于引用类型，== 被视为继承自 Object 的 equals 方法的别名。比如对于字符串比较：
  //而在 Java 里，x 与 y 的比较结果将是 false。程序员在这种情况应该用 equals，不过它容易被忘记。

  // 然而，有些情况下，你可能需要使用引用相等代替用户定义的相等。例如，某些时候效率是首要因素，
  // 你想要把某些类进行哈希合并（ hash cons ），然后通过引用相等比较它们的实例。为了满足这种情况，
  // 类 AnyRef 定义了附加的 eq 方法，它不能被重载并且实现为引用相等（也就是说，它表现得就像Java里对于引用类型的 == 那样）。
  // 同样也有一个 eq 的反义词，被称为 ne 。例如：
  def streql() = new String("abc") == new String("abc")
  def strne() = new String("def") eq new String("def")
  def streq() = new String("ghi") ne new String("ghi")

  //要注意的是，逻辑运算支持“短路运算”，比如 op1 || op2 ，
  // 当 op1=true ，op2 无需再计算，就可以知道结果为 true 。这时 op2 表示式不会执行。例如：
  def salt() = {
    println("salt")
    false
  }

  def peper() = {
    println("peper")
    true
  }

  def main(args: Array[String]): Unit = {
    println(hex)
    println(hex2)
    println(prog)
    println(litter)
    println(big)
    println(a)
    println(f)
    println(hello)
    println(longString)
    println(bool)
    println("==================")
    println(testabs)
    println(testabs1)
    println(testmax)
    println(testrange)
    println("==================")
    println(s+"index of o is ", index) // 4
    println(lowerCase)
    println("==================")
    println(1.2 + 2.3)
    println('b'-'a')
    println(11%4)
    println(11.0f / 4.0f)
    println(2L * 3L)
    println("=======位操作===========")
    println( 1&2 )
    println( 1|2 )
    println( 1^2 )
    println( ~1 )
    println("Scala 的 == 和Java不同，scala 的 == 只用于比较两个对象的值是否相同。而对于引用类型的比较使用另外的操作符 eq 和 ne")
    println("=======对象恒等比较===========")
    println(isEqual(421,421))
    println(isEqual(421,421))
    println("=======对象恒等比较===========")
    println(streql())
    println(streq())
    println(strne())
    println("=======短路运算===========")
    println(peper() && salt())
    println(salt() && peper())
  }
}
