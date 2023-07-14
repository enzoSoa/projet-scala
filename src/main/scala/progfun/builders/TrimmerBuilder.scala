package progfun.builders

import progfun.exceptions.InputFormatException
import progfun.types.{Location, Position, Trimmer}

object TrimmerBuilder {
  def fromInput(
      input: List[String]): Either[InputFormatException, List[Trimmer]] =
    input.grouped(2).toList match {
      case inputs if inputs.length > 0 => parseInputs(inputs)
      case _ =>
        Left(
          new InputFormatException(
            "Your input file must contain at least 1 trimmer declaration"
          )
        )
    }

  private def parseInputs(
      inputs: List[List[String]]): Either[InputFormatException, List[Trimmer]] =
    generateTrimmers(inputs) match {
      case trimmers if trimmers.forall(_.isRight) =>
        Right(trimmers.collect { case Right(trim) => trim })
      case trimmers => handleTrimmerListWithErrors(trimmers)
    }

  private def handleTrimmerListWithErrors(
      trimmers: List[Either[InputFormatException, Trimmer]])
      : Either[InputFormatException, List[Trimmer]] =
    trimmers.find(_.isLeft) match {
      case Some(Left(value)) => Left(value)
      case _                 => Right(List[Trimmer]())
    }

  private def generateTrimmers(
      inputs: List[List[String]]): List[Either[InputFormatException, Trimmer]] =
    inputs.map {
      case List(firstLine, secondLine) =>
        for {
          position     <- parseLineAsPosition(firstLine)
          instructions <- parseLineAsInstructions(secondLine)
        } yield Trimmer(position, instructions)
      case _ =>
        Left(
          new InputFormatException(
            "Trimmer configuration have to always be two lines"
          )
        )
    }

  private def parseLineAsPosition(
      input: String): Either[InputFormatException, Position] =
    input.split(" ") match {
      case Array(x, y, d) if d == "N" || d == "E" || d == "S" || d == "W" =>
        Right(Position(Location(x.toInt, y.toInt), d))
      case _ =>
        Left(
          new InputFormatException(
            "Trimmer Position must use this format : x y d"
          )
        )
    }

  private def parseLineAsInstructions(
      input: String): Either[InputFormatException, List[String]] =
    input.split("") match {
      case instructions
          if instructions.forall(c => c == "D" || c == "G" || c == "A") =>
        Right(instructions.toList)
      case _ =>
        Left(new InputFormatException("Trimmer instructions must be D, G or A"))
    }
}
