package utils
import scala.io.Source

class ParseInput {
    
    def SeqInt(fileName: String): Seq[Int] = {
        Source.fromFile(fileName).getLines.map(_.toInt).toSeq
    }

    def SeqString(fileName: String): Seq[String] = {
        Source.fromFile(fileName).getLines.toSeq
    }

}
object ParseInput{
    def apply(): ParseInput = {
        new ParseInput()
    }
}