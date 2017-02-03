package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
trait BaseModule {

  def name(): String

  def help() = {
    helpPrinter.generateModuleHelp(name())
  }


  def help(command: String) = {
    helpPrinter.generateCommandHelp(name(), command)
  }

}
