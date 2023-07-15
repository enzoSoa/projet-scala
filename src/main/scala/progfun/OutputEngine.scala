package progfun

import progfun.types.Result

object OutputEngine {
  def execute(result: Result): String = result.toYaml(0)
}
