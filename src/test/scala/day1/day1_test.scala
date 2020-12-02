package day1

import org.scalatest.FlatSpec
import utils.ParseInput

class Puzzle1Test extends FlatSpec {
    "An empty list" should "have size 0" in {
        assert(List.empty.size == 0)
    }

    "Test input" should "match" in {
        val testInput = Seq(1721, 979, 366, 299, 675, 1456)
        val sum = 2020
        val dut = new Puzzle1
        assert(dut.findAndMultiply(sum,testInput) == 514579)
    }

    "findSum" should "work on testinput" in {
        val testInput = Seq(1721, 979, 366, 299, 675, 1456)
        val sum = 2020
        val n = 2
        val dut = new Puzzle1
        val res = dut.findSum(sum,n,testInput)
        assert(res._1 == true)
        assert(res._2.reduce({_ * _}) == 514579)
    }

    "findSum" should "work for puzzle1" in {
        val parser = new ParseInput
        val puzzleInput = parser.SeqInt("src/main/resources/testInput/day1/puzzl1.txt")
        val sum = 2020
        val n = 2
        val dut = new Puzzle1
        val res = dut.findSum(sum,n,puzzleInput)

        assert(res._1 == true)
        assert(res._2.reduce({_ * _}) == 1016131)


    }

}