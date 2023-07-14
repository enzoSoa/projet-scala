package fr.esgi.al.funprog

import progfun.InputParser

object Main extends App {
  val instructions = InputParser.execute()
  instructions match {
    case Right(value)    => print(value)
    case Left(exception) => print(exception.toString())
  }
}
