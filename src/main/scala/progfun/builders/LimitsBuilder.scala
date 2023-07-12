package progfun.builders

import progfun.types.Limits
import progfun.exceptions.InputFormatException

object LimitsBuilder {
  def fromInput(input: String): Either[InputFormatException, Limits] =
    input.split(" ").toList match {
      case first :: second :: _ => Right(Limits(first.toInt, second.toInt))
      case _ =>
        Left(
          new InputFormatException(
            "Input file must start with 2 int indicating the garden size with this format 'x y'"
          )
        )
    }
}
