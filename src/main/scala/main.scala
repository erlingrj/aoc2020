package main
import day1._
import day2._

object MainObj {
    def main(args: Array[String]): Unit = {
        
        println("Hello World")
        val d2 = new Day2
        println(d2.solve)
        val d2p2 = new Puzzle2
        println(d2p2.solve())

    }
}