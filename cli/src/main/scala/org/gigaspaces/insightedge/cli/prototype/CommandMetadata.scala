package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
case class CommandMetadata(name: String, help: String, arguments: List[ArgumentMetadata])

case class ArgumentMetadata(name: String, help: String/*, argType: Class[_]*/)
