package org.gigaspaces.core

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
