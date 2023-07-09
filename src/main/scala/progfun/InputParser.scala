package progfun

import com.typesafe.config.ConfigFactory

object InputParser {
  def getInputFileLocation = () => {
    val globalConf = ConfigFactory.load()
    globalConf.getString("application.input-file")
  }
}
