package progfun.types

case class Result(limite: Limits, tondeuses: List[ProcessedTrimmer]) {
  def toJson(indent: Int) = f"{\n" +
    f"${"    " * (indent + 1)}\"limite\": ${limite.toJson(indent + 1)},\n" +
    f"${"    " * (indent + 1)}\"tondeuses\": [\n" +
    f"${"    " * (indent + 2)}${tondeuses
        .map(tondeuse => tondeuse.toJson(indent + 2))
        .mkString(f",\n${"    " * (indent + 2)}")}\n" +
    f"${"    " * (indent + 1)}]\n" +
    f"${"    " * indent}}"
}
