package progfun

import com.typesafe.config.ConfigFactory
import better.files._
import progfun.exceptions.InputFormatException
import progfun.builders.LimitsBuilder
import progfun.types.{Instructions, Limits, Trimmer}
import progfun.builders.TrimmerBuilder

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

  private def parseInputsIntoInstructions(
      input: List[String]): Either[InputFormatException, Instructions] = for {
    limits   <- getLimitsFromInput(input)
    trimmers <- getTrimmersFromInput(input)
  } yield Instructions(limits, trimmers)

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

  private def getTrimmersFromInput(
      input: List[String]): Either[InputFormatException, List[Trimmer]] =
    input match {
      case _ :: tail => TrimmerBuilder.fromInput(tail)
      case _ =>
        Left(
          new InputFormatException(
            "Input file must contain at least 1 trimmer configuration"
          )
        )
    }
}
