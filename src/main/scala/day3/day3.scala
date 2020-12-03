package day3

import utils.ParseInput


class Day3 {
  val TREE: Char = "#".toList(0)
  val OPEN: Char = ".".toList(0)

  case class Slope(right: Int, down: Int)
  case class Position(var x: Int, var y: Int)


  def countTrees(input: Seq[String], slope: Slope, start: Position, debug: Boolean): Int = {
    // Calculate the number of iterations through the matrix
    // If we are limited in the y/down direction this is the last iteration
    // if we are limited in the x/right direction we must call ourselves recursively again
    val xSize = input(0).length
    val ySize = input.length
    if (debug) println(s"${start}, ${slope}, xSize=${xSize} ySize=${ySize}")
    val (iterations, exit) = {
      val xIt: Int = (xSize - start.x-1)/slope.right
      val yIt: Int = ((ySize - start.y-1)/slope.down)
      if ( xIt >= yIt) {
        if (debug) println(s"y-constrained, nIt=${yIt}")
        (yIt, true)
      }
      else {
        if (debug) println(s"x-constrained, nIt=${xIt}")
        (xIt, false)
      }
    }
    // Count the trees
    var count = 0
    var currentPos = start.copy()
    for (i <- 0 to iterations) {
      if (debug) println(s"${currentPos}")
      if (input(currentPos.y)(currentPos.x) == TREE) {
        if (debug) println(s"Found tree at (${currentPos.x},${currentPos.y})")
        count += 1
      }
      currentPos.x += slope.right
      currentPos.y += slope.down
    }

    if (exit) {
      return count
    } else {
      val nextStartPos = Position(currentPos.x % xSize, currentPos.y % ySize)
      if (debug) println(s"nextStartPos=${nextStartPos}")

      return count + countTrees(input, slope, nextStartPos, debug)
    }

  }

  def _solve1(input: Seq[String], start: Position, slope: Slope, debug: Boolean): Int = {
    return countTrees(input, slope, start, debug)
  }


  def solve1(): Int = {
    val parser = new ParseInput
    val testInput = parser.SeqString("src/main/resources/day3/puzzle1.txt")

    return _solve1(testInput, Position(0,0), Slope(3,1), false)
  }

  def solve2(): Long = {
    val parser = new ParseInput()
    val in = parser.SeqString("src/main/resources/day3/puzzle1.txt")
    val start = Position(0,0)
    val nTrees : Seq[Long] = Seq(
      _solve1(in, start, Slope(1,1), false),
      _solve1(in, start, Slope(3,1), false),
      _solve1(in, start, Slope(5,1), false),
      _solve1(in, start, Slope(7,1), false),
      _solve1(in, start, Slope(1,2), false)
    )
    println(nTrees)
    nTrees.product
  }
}
