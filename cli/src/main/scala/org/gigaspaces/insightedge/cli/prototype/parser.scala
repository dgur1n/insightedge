package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
object parser {

  def parse(command: Array[String]): CommandData = {
    val moduleCommand = command(0).split("-")

    val module = moduleCommand(0)
    val commandName = moduleCommand(1)

    val argStrings = command.tail

    val args = argStrings.map{ arg =>
      val splitted = arg.split("=")
      val name = splitted(0).substring(2)
      val value = splitted(1)
      ArgumentData(name, value)
    }.toList

    CommandData(module, commandName, args)
  }

}
