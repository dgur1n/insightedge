package org.gigaspaces.core

/**
  * @author Vitaliy_Zinchenko
  */
object commandToCodeConverter {
  def convert(commandData: CommandData, commandMetadata: CommandMetadata): String = {
    val args = commandData.args.map{ arg =>
      val argMetadata = commandMetadata.arguments.find(_.name == arg.name).get
      s"${arg.name}=${getValue(arg, argMetadata)}"
    }
    s"${commandData.module.get}.${commandData.command.get}(${args.mkString(",")})"
  }

  private def getValue(argData: ArgumentData, argMetadata: ArgumentMetadata): String = {
    if(argMetadata.required) s""""${argData.value}""""
    else s"""Some(\"${argData.value}\")"""
  }
}