package org.gigaspaces.insightedge.cli.prototype

import org.gigaspaces.insightedge.cli.grid

import scala.sys.process._

/**
  * @author Vitaliy_Zinchenko
  */
object helpMain extends App {

  moduleRegistry.register("grid", grid)

  val commandData = parser.parse(args)

  if (commandData.module.isEmpty) cliLevelHelp()
  else if (commandData.command.isEmpty) moduleLevelHelp(commandData.module.get)
  else commandLevelHelp(commandData.module.get, commandData.command.get)

  def help(): Unit = {

  }

  private def cliLevelHelp() = {
    helpPrinter.generateRootHelp(moduleRegistry.moduleNames)
  }

  private def moduleLevelHelp(module: String) = {
    helpPrinter.generateModuleHelp(module)
  }

  private def commandLevelHelp(module: String, command: String) = {
    helpPrinter.generateCommandHelp(module, command)
  }

}
