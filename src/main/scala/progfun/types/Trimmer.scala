package progfun.types

case class Location(x: Int, y: Int) {
  def toJson(indent: Int) = f"{\n" +
    f"${"    " * (indent + 1)}\"x\": $x,\n" +
    f"${"    " * (indent + 1)}\"y\": $y\n" +
    f"${"    " * indent}}"
}

case class Position(point: Location, direction: String) {
  def toJson(indent: Int) = f"{\n" +
    f"${"    " * (indent + 1)}\"point\": ${point.toJson(indent + 1)},\n" +
    f"${"    " * (indent + 1)}\"direction\": \"$direction\"\n" +
    f"${"    " * indent}}"
}

case class Trimmer(debut: Position, instructions: List[String])

case class ProcessedTrimmer(
    debut: Position,
    instructions: List[String],
    fin: Position) {
  def toJson(indent: Int) = f"{\n" +
    f"${"    " * (indent + 1)}\"debut\": ${debut.toJson(indent + 1)},\n" +
    f"${"    " * (indent + 1)}\"direction\": [${instructions.mkString(",")}],\n" +
    f"${"    " * (indent + 1)}\"fin\": ${fin.toJson(indent + 1)}\n" +
    f"${"    " * indent}}"
}
