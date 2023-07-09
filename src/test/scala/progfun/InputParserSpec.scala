package progfun

import org.scalatest.funsuite.AnyFunSuite

class InputParserSpec extends AnyFunSuite {
  test("InputParser object should find the configuration file") {
    val configLocation = InputParser.execute()
    assert(configLocation === "/tmp/input.txt")
  }
}
