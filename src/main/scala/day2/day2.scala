package day2

import utils.ParseInput

class Day2 {

  type PassData = Tuple4[Int, Int, Char, String]

  def parseLine(line: String) : PassData  = {
    val min = line.split('-')(0).toInt
    val max = line.split('-')(1).split(' ')(0).toInt

    val pass = line.split('-')(1).split(' ')(2)

    val ch = line.split('-')(1).split(' ')(1).split(':')(0).toList(0)
    val ret = new PassData(min,max,ch,pass)
    ret
  }

  def validatePassword(passData: PassData) : Boolean = {
    var cnt = 0
    for (ch <- passData._4) {
      if (ch == passData._3) {
        cnt += 1
      }
    }

    ((cnt <= passData._2) && (cnt >= passData._1))
  }

  def _solve(input: Seq[String]): Int = {
    input.map( {
      a => if(validatePassword(parseLine(a))) 1 else 0
    }).sum
  }

  def solve(): Int = {
    val parser = new ParseInput
    val input = parser.SeqString("src/main/resources/day2/puzzle1.txt")
    _solve(input)
  }
}


class Puzzle2 extends Day2{

  override def validatePassword(passData: PassData) : Boolean = {
    val ch = passData._3
    val p1 = passData._1
    val p2 = passData._2

    val pass = passData._4

    (pass(p1-1) == ch) ^ (pass(p2-1) == ch)

  }
}
