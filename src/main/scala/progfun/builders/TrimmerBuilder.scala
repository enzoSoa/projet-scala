package progfun.builders

import progfun.exceptions.InputFormatException
import progfun.types.Trimmer

object TrimmerBuilder {
  def fromInput(
      input: List[String]): Either[InputFormatException, List[Trimmer]] =
    input.grouped(2).toList.map {
      case first :: second :: _ => Right(Trimmer(first, second))
      case _ =>
        Left(
          new InputFormatException(
            "Trimmers configuration should always have 2 lines"
          )
        )
    }

  private def inputFrom2Lines(
      firstLine: String,
      secondLine: String): Either[InputFormatException, Trimmer] = {
    val firstLineSplit = firstLine.split(" ").toList
    val secondLineSplit = secondLine.split("").toList
  }

  private def getPositionFromInputLine(
      input: String): Either[InputFormatException, Trimmer] = {}

  private def getDirectionFromInputChar(
      inputChar: String): Either[InputFormatException, Char] = inputChar match {
    case "D" | "G" | "A" => Right(inputChar)
    case _ =>
      Left(
        new InputFormatException(
          "Trimmer direction must be one of the following: N, E, S, W"
        )
      )
  }
}
