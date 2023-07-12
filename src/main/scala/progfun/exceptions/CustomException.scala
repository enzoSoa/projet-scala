package progfun.exceptions

case class CustomException(errorMessage: String) extends Throwable {
  private val exceptionType: String = "Exception"

  def toString(): String = f"${this.exceptionType} : ${errorMessage}"
}
