package year2021.day02

import scala.io.Source

object Task01 extends App {
  /**
   * Calculate the horizontal position and depth you would have after following the planned course.
   * What do you get if you multiply your final horizontal position by your final depth?
   */
  def aggregateMovements(movements: List[String]): Int = {
    movements.map(_.split(" ").lift(1).getOrElse("0").toInt).sum
  }

  val inputFile = Source.fromFile("src/main/resources/data/year2021/day02/input.txt")
  val inputData = inputFile.getLines().toList
  val forwardMovements = aggregateMovements(inputData.filter(_ contains "forward"))
  val upMovements = aggregateMovements(inputData.filter(_ contains "up"))
  val downMovements = aggregateMovements(inputData.filter(_ contains "down"))
  var result = (downMovements - upMovements) * forwardMovements
  println(result)
}
