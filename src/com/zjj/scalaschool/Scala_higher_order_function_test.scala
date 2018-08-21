/**
  * <p>User: Zhang Junjun
  * <p>Date: 18/8/21
  * <p>Version: 1.0
  */

// It is also possible to pass methods as arguments to higher-order functions because
// the Scala compiler will coerce the method into a function.
case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
}

object Scala_higher_order_function_test{

  def smallPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * salary)

  // Notice how each of the three methods vary only by the multiplication factor.
  // To simplify, you can extract the repeated code into a higher-order function like so:

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion1(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion1(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

  // Functions that return functions
  // There are certain cases where you want to generate a function.
  // Here’s an example of a method that returns a function.
  def urlBuilder(ssl: Boolean, domainName: String): (String,String) => String = {
    val schema = if (ssl) "https://" else "http://"
    // Notice the return type of urlBuilder (String, String) => String.
    // This means that the returned anonymous function takes two Strings and returns a String.
    // In this case, the returned anonymous function is (endpoint: String, query: String) => s"https://www.example.com/$endpoint?$query".
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }
  def main(args: Array[String]): Unit = {
    // One of the most common examples is the higher-order function map
    // which is available for collections in Scala.
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x : Int) => x * 2
    val newSalaries = salaries.map(doubleSalary)

    val newSalaries2 = salaries.map(x => x * 3)

    var newSalaries3 = salaries.map(_ * 4)
    println(newSalaries)
    println(newSalaries2)
    println(newSalaries3)

    println(smallPromotion(List(1.2,2.23,5,6)))
    println(greatPromotion(List(1.2,2.23,5,6)))
    println(hugePromotion(List(1.2,2.23,5,6)))

    val domainName = "www.example.com"
    def getURL = urlBuilder(ssl=true, domainName)
    val endpoint = "users"
    val query = "id=1&hello=world"
    val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
    println(url)
  }
}

