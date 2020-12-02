package day2


import org.scalatest.FlatSpec
import utils.ParseInput

class Day2Test extends FlatSpec {
  "An empty list" should "have size 0" in {
    assert(List.empty.size == 0)
  }

  "Day2 Test input" should "match" in {
    val testInput = Seq("1-3 a: abcde",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc")
    val dut = new Day2
    assert(dut._solve(testInput) == 2)
  }

}