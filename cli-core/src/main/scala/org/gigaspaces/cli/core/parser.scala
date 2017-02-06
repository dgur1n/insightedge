package org.gigaspaces.cli.core

/**
  * @author Vitaliy_Zinchenko
  */
object parser {

  val commandDelimiter = "-"
  val argDelimiter = "="

  def parse(command: Array[String]): Option[CommandData] = {
    if (command.isEmpty) return None

    val commandModule = command.head

    val args = command.tail
      .filter(_.contains(argDelimiter))
      .map { arg =>
        val Array(nameFlug, value)= arg.split(argDelimiter)
        val name = nameFlug.substring(2)
        ArgumentData(name, value)
      }.toList

    if (commandModule.contains(commandDelimiter)) {
      val Array(module, commandName) = commandModule.split(commandDelimiter)
      Some(CommandData(Some(module), Some(commandName), args))
    } else {
      Some(CommandData(Some(commandModule), None, args))
    }
  }

}
