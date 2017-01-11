package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
object validator {

  def isValidate(commandData: CommandData, commandMetadata: CommandMetadata): Boolean = { // TODO use appropriate return type
    if(commandData.command != commandMetadata.name) false
    else true
  }

  def isValidCommandName(commandName: String, moduleMetadata: ModuleMetadata): Boolean = {
    moduleMetadata.methods.contains(commandName)
  }

}
