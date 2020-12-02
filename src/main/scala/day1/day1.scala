package day1

import utils.ParseInput
import java.nio.file.Paths

class Puzzle1 {
    def findAndMultiply(sum: Int, input: Seq[Int]): Int =  {
        for ( (el, idx) <- input.zipWithIndex) {
            for (el2 <- input.drop(1)) {
                if ((el+el2) == sum) {
                    return el*el2
                }
            }
        } 
        0
    }


    def findSum(sum: Int, n: Int, input: Seq[Int]): Tuple2[Boolean, Seq[Int]] = {
        if (sum <= 0) {
            return Tuple2(false, Seq())
        }

        if (n == 1) {
            if (input.contains(sum)) {
                return Tuple2(true, Seq(sum))
            } else {
                return Tuple2(false, Seq())
            }
        } else {
            for (el <- input) {
                val res =findSum(sum-el, n-1, input.drop(1)) 
                if (res._1 == true) {
                    return Tuple2(true, res._2 ++ Seq(el) )
                }
            }

            return Tuple2(false, Seq())
        }
    } 


    def solve(): Int = {
        val parser = new ParseInput
        val puzzleInput = parser.SeqInt("src/main/resources/testInput/day1/puzzl1.txt")
        
        
        return findAndMultiply(2020, puzzleInput)
    }


    def solve2(): Int = {
        val parser = new ParseInput
        val puzzleInput = parser.SeqInt("src/main/resources/testInput/day1/puzzl1.txt")

        return findSum(2020,3,puzzleInput)._2.reduce({_*_})
    }
}