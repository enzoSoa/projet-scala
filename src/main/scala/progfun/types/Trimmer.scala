package progfun.types

case class Location(x: Int, y: Int)

case class Position(point: Location, direction: String)

case class Trimmer(debut: Position, instructions: List[String])

case class ProcessedTrimmer(
    debut: Position,
    instructions: List[String],
    fin: Position)
