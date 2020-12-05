package day5

import utils.ParseInput

import scala.math.pow

class Day5 {

  case class Seat(row: Int, col: Int, id: Int)
  def parseBinarySpacePartition(in: String) : Seat = {

    val row = in.take(7)
      .map({ ch =>
        ch match {
      case 'F' => 0
      case 'B' => 1
      case _ => throw new Exception(s"charactre $ch invalid")
    }}).reverse.zipWithIndex
      .map({ el =>
        if(el._1 == 1) pow(2,el._2) else 0.0
      }).sum.toInt

    val col = in.takeRight(3)
      .map({ ch =>
        ch match {
          case 'L' => 0
          case 'R' => 1
          case _ => throw new Exception(s"charactre $ch invalid")
        }}).reverse.zipWithIndex
      .map({ el =>
        if(el._1 == 1) pow(2,el._2) else 0.0
      }).sum.toInt

    Seat(row,col,row*8 + col)
  }

  def _solve1(input: Seq[String]): Int = {
    input.map(parseBinarySpacePartition).map(_.id).max
  }

  def _solve2(input: Seq[String]): Int = {
    val idx = input.map(parseBinarySpacePartition).sortBy(_.id).sliding(2).map({ a =>
      if (a(1).id == a(0).id+1) true
      else false
    }).indexWhere(_ == false)
    println(input.map(parseBinarySpacePartition).sortBy(_.id).toIndexedSeq)
    input.map(parseBinarySpacePartition).sortBy(_.id).toIndexedSeq(idx).id+1

    }

  def solve1(): Int = {
      val parser = new ParseInput()
      val in = parser.SeqString("src/main/resources/day5/puzzle1.txt")
      _solve1(in)
  }

  def solve2(): Int = {
  val parser = new ParseInput()
  val in = parser.SeqString("src/main/resources/day5/puzzle1.txt")
  _solve2(in)
}


}
