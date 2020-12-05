package day4

import utils.ParseInput
import scala.collection.mutable.ListBuffer


class Day4 {
  case class Height(h: String)
  case class HairColour(colour: Int)
  case class EyeColour(colour: String)
  case class Passport(byr: BigInt,
                      iyr: BigInt,
                      eyr: BigInt,
                      hgt: Height,
                      hcl: HairColour,
                      ecl: EyeColour,
                      pid: BigInt,
                      cid: BigInt)

  def parseInt(in: String): BigInt = {
    try {
      BigInt(in)
    } catch {
      case e: Exception => {
        println(s"parseInt $in failed")
        -1
      }
    }
  }

  def parseHairCoulour(in: String): HairColour = {
    var input = in
    if(in(0) == '#') {
      input = in.drop(1)
    }

    try {
        HairColour(Integer.parseInt(input, 16))
      } catch {
        case e: Exception => {
          println(s"haircolour ${in} failed")
          HairColour(0)
        }
      }
  }


  def parseHeight(in: String): Height = {
    if(in.endsWith("in") || in.endsWith("cm") || in.endsWith("\'")) {
      Height(in)
    } else {
      try {
        var test = in.toInt
        Height(test.toString)
      } catch {
        case _ => {
          println(s"Parseheight $in failed")
          Height("null")
        }
      }
    }
  }

  def parseEyeColour(in: String): EyeColour = {
    if (in.length == 3 || in(0) =='#') {
      EyeColour(in)
    } else {
      if (in(0) == '#') {
        in.drop(1)
      }
      try {
        EyeColour(Integer.parseInt(in, 16).toString)
      } catch {
        case e: Exception => {
          println(s"parseEyeColour $in failed")
          EyeColour("null")
        }
      }

    }
  }

  // Takes sequence of lines and turns it into sequence of passports
  def parseStringToPassport(input: String): Passport = {
    var byr= BigInt(-1);var iyr= BigInt(-1); var eyr= BigInt(-1); var hgt=Height("null"); var hcl=HairColour(-1); var ecl=EyeColour("null"); var pid= BigInt(-1); var cid= BigInt(-1);
    input.split(" ")
      .map({
        (str) =>
          val key = str.split(":")(0)
          val value = str.split(":")(1)
            key match {
              case "byr" => byr = 1//parseInt(value)
              case "iyr" => iyr = 1//parseInt(value)
              case "eyr" => eyr = 1//parseInt(value)
              case "pid" => pid = 1//parseInt(value)
              case "cid" => cid = 1//parseInt(value)
              case "hgt" => hgt = Height("test")//parseHeight(value)
              case "hcl" => hcl = HairColour(1) //"parseHairCoulour(value)
              case "ecl" => ecl = EyeColour("test") //parseEyeColour(value)
              case _ => println(s"key=${key} value={value}")
            }
      })

    Passport(byr,iyr,eyr,hgt, hcl, ecl, pid, cid)
  }

  def parseInputToIndividualPassports(input: Seq[String]): Seq[String] = {
    var runningSeq = ""
    var resSeq = new ListBuffer[String]()

    for (lines <- input) {
      if (lines.nonEmpty) {
        runningSeq += lines + " "
      } else {
        if (runningSeq.nonEmpty) {
          println(runningSeq)
          resSeq += runningSeq.trim
          runningSeq = ""
        }
      }
    }
    if (runningSeq.nonEmpty) {
      resSeq += runningSeq
    }
    resSeq.toSeq

  }


  def validatePassport(p: Passport): Boolean = {
   if(p.byr != -1 && p.eyr != -1 && p.eyr != -1 &&
      p.hgt.h != "null" && p.hcl.colour != -1 && p.ecl.colour != "null" &&
      p.pid != -1) {
     return true
   } else {
     println(p)
     return false
   }

  }

  def _solve1(input: Seq[String]): Int = {
    parseInputToIndividualPassports(input)
      .map(parseStringToPassport(_))
      .map(validatePassport(_))
      .count(_ == true)
  }


  def solve1(): Int = {
    val parser = new ParseInput()
    val in = parser.SeqString("src/main/resources/day4/puzzle1.txt")
    _solve1(in)
  }

}
