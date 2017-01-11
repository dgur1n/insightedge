package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
case class CommandData(module: String, command: String, args: List[ArgumentData])

case class ArgumentData(name: String, value: String)
