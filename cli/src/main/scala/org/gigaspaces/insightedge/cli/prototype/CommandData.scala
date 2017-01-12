package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
case class CommandData(module: Option[String] = None, command: Option[String] = None, args: List[ArgumentData] = Nil)

case class ArgumentData(name: String, value: String)
