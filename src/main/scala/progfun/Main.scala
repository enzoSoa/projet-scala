package fr.esgi.al.funprog

import progfun.InputParser
import scala.util.Failure
import scala.util.Success
// import scala.util.{Failure, Success, Try}

object Main extends App {
  val instructions = InputParser.execute()
  instructions match {
    case Success(value) => print(value)
    case Failure(exception) => {
      print(exception)
      System.exit(1)
    }
  }
}
