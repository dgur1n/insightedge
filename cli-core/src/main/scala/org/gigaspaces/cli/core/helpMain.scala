package org.gigaspaces.cli.core

//import org.gigaspaces.insightedge.cli.grid

/**
  * @author Vitaliy_Zinchenko
  */
object helpMain extends App {

//  moduleRegistry.register("grid", grid) // TODO - temporary registration

  parser.parse(args) match {
    case None => cliLevelHelp()
    case Some(CommandData(Some(module), None, _)) => moduleLevelHelp(module)
    case Some(CommandData(Some(module), Some(command), _)) => commandLevelHelp(module, command)
  }

  def help(): Unit = {
    cliLevelHelp()
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
