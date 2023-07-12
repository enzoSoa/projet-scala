package progfun

import com.typesafe.config.ConfigFactory
import better.files._
import progfun.types.Limits
import progfun.exceptions.InputFormatException
import progfun.builders.LimitsBuilder
import scala.util.{Failure, Success, Try}

object InputParser {
  def execute() = {
    val inputLocation = getInputFileLocation()
    val input = getInputInstructions(inputLocation)
    parseInputsIntoInstructions(input)
  }

  private def getInputInstructions(inputLocation: String): List[String] = File(
    inputLocation
  ).lines.toList

  private def getInputFileLocation(): String = {
    val globalConf = ConfigFactory.load()
    globalConf.getString("application.input-file")
  }

  private def parseInputsIntoInstructions(input: List[String]): Try[Limits] =
    getLimitsFromInput(input).fold(
      limitError => Failure(limitError),
      limits => Success(limits)
    )

  private def getLimitsFromInput(
      input: List[String]): Either[InputFormatException, Limits] =
    input.headOption match {
      case None =>
        Left(
          new InputFormatException(
            "Input file must start with 2 int indicating the garden size with this format 'x y'"
          )
        )
      case Some(value) => LimitsBuilder.fromInput(value)
    }
}
