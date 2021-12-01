package year2021.day01.task01

import scala.io.Source
import scala.annotation.tailrec

object Solution extends App {
  /**
   * Count the number of times a depth measurement increases from the previous measurement.
   */
  def compareMeasurements(n: Int): Boolean = {
    if (inputData.lift(n).getOrElse(0) > inputData.lift(n-1).getOrElse(0)) true
    else false
  }

  def countMeasurementIncreases(n: Int): Int = {
    @tailrec
    def loop(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else {
        if (compareMeasurements(x)) loop(x-1, acc+1)
        else loop(x-1, acc)
      }
    }
    loop(n, 0)
  }

  val inputFile = Source.fromFile("src/main/resources/data/year2021/day01/task01/input.txt")
  val inputData: List[Int] = inputFile.getLines().toList.map(_.toInt)
  inputFile.close()

  val result = countMeasurementIncreases(inputData.length)

  println(result)
}
