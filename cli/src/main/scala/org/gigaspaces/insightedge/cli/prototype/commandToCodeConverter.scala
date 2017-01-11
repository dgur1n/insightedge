package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
object commandToCodeConverter {
  def convert(commandData: CommandData): String = {
    val args = commandData.args.map{ arg =>
      s"""${arg.name}="${arg.value}""""
    }
    s"${commandData.module}.${commandData.command}(${args.mkString(", ")})"
  }
}
