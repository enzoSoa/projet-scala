package fr.esgi.al.funprog

import progfun.{GardeningEngine, InputParser}
import scala.util.Failure
import scala.util.Success
// import scala.util.{Failure, Success, Try}

object Main extends App {
  InputParser.execute() match {
    case Success(instructions) =>
      GardeningEngine.execute(instructions) match {
        case Failure(exception) => print(exception)
        case Success(value)     => print(value)
      }
    case Failure(exception) => {
      print(exception)
      System.exit(1)
    }
  }
}
