package day4
import org.scalatest.FlatSpec
import utils.ParseInput


class Day4Test extends FlatSpec {

  "An empty list" should "have size 0" in {
    assert(List.empty.size == 0)
  }


  "Day 4 Test input" should "match" in {
    val parser = new ParseInput()
    val testInput = parser.SeqString("src/main/resources/day4/test.txt")
    val dut = new Day4
    assert(dut._solve1(testInput) == 2)
  }

}
