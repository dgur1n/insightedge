package org.gigaspaces.core

/**
  * @author Vitaliy_Zinchenko
  */
object validator {

  def isValidate(commandData: CommandData, commandMetadata: CommandMetadata): Boolean = { // TODO use appropriate return type
    val absentArgs = commandMetadata.arguments
      .filter(_.required)
      .filter{ arg =>
        !commandData.args.map(_.name).contains(arg.name)
      }.map(_.name)

    if(absentArgs.nonEmpty) {
      println(s"Specify arguments: ${absentArgs.mkString(", ")}")
      false
    } else true
  }

  def isValidCommandName(commandName: String, moduleMetadata: ModuleMetadata): Boolean = {
    moduleMetadata.methods.contains(commandName)
  }

}
