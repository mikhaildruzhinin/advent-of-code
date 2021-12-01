package year2021.day01

import scala.annotation.tailrec
import scala.io.Source

object Task02 extends App {
  /**
   * Count the number of times the sum of measurements in three-measurement sliding window increases.
   */
  def compareMeasurements(n: Int): Boolean = {
    val secondMeasurement = inputData.slice(n, n + 3)
    val firstMeasurement = inputData.slice(n - 1, n + 2)
    if (secondMeasurement.sum > firstMeasurement.sum) true
    else false
  }

  def countMeasurementIncreases(n: Int): Int = {
    @tailrec
    def loop(x: Int, acc: Int): Int = {
      if (x >= inputDataLength - 2) acc
      else {
        if (compareMeasurements(x)) loop(x + 1, acc + 1)
        else loop(x + 1, acc)
      }
    }

    loop(1, 0)
  }

  val inputFile = Source.fromFile("src/main/resources/data/year2021/day01/input.txt")
  val inputData: List[Int] = inputFile.getLines().toList.map(_.toInt)
  inputFile.close()
  val inputDataLength = inputData.length

  val result = countMeasurementIncreases(inputDataLength)
  println(result)
}
