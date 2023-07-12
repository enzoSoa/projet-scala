package progfun.exceptions

class InputFormatException(exceptionMessage: String)
    extends CustomException(exceptionMessage) {
  override def exceptionType: String = "Wrong Input File Format Exception"
}
