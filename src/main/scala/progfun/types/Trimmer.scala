package progfun.types

case class Location(x: Int, y: Int)

case class Position(point: Location, direction: Char)

case class Trimmer(debut: Position, instructions: List[Char])
