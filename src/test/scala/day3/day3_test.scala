package day3

import org.scalatest.FlatSpec
import utils.ParseInput


class Day3Test extends FlatSpec {

  "An empty list" should "have size 0" in {
    assert(List.empty.size == 0)
  }


  "Day 3 Test input" should "match" in {
    val parser = new ParseInput()
    val testInput = parser.SeqString("src/main/resources/day3/test.txt")
    val dut = new Day3
    assert(dut._solve1(testInput, dut.Position(0,0), dut.Slope(3,1), false) == 7)
  }


  "Day3 Puzzle 2 test input" should "match" in {
    val parser = new ParseInput()
    val in = parser.SeqString("src/main/resources/day3/test.txt")
    val dut = new Day3
    val start = dut.Position(0,0)
    val nTrees = Seq(
        dut._solve1(in, start, dut.Slope(1,1), false),
        dut._solve1(in, start, dut.Slope(3,1), false),
        dut._solve1(in, start, dut.Slope(5,1), false),
        dut._solve1(in, start, dut.Slope(7,1), false),
        dut._solve1(in, start, dut.Slope(1,2), false)
    )
    println(nTrees)
    assert(nTrees == Seq(2,7,3,4,2))
  }
}
