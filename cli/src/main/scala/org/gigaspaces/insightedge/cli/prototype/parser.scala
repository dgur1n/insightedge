package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
object parser {

  val commandDelimiter = "-"
  val argDelimiter = "="

//  def parse(commandModule: String): CommandData = {
//    if (!commandModule.contains(commandDelimiter)) CommandData(commandModule)
//    else {
//      val Array(module, commandName) = commandModule.split(commandDelimiter)
//      CommandData(module, Some(commandName))
//    }
//  }

  def parse(command: Array[String]): CommandData = {
    if (command.isEmpty) return CommandData()

    val commandModule = command.head
    val data = if (!commandModule.contains(commandDelimiter)) CommandData(Some(commandModule))
    else {
      val Array(module, commandName) = commandModule.split(commandDelimiter)
      CommandData(Some(module), Some(commandName))
    }

    val argStrings = command.tail

    val args = argStrings
      .filter(_.contains(argDelimiter))
      .map { arg =>
        val Array(nameFlug, value)= arg.split(argDelimiter)
        val name = nameFlug.substring(2)
        ArgumentData(name, value)
      }.toList

    if(args.nonEmpty) data.copy(args = args) else data
  }

}
