package org.gigaspaces.core

/**
  * @author Vitaliy_Zinchenko
  */
case class CommandMetadata(name: String, help: String, arguments: List[ArgumentMetadata])

case class ArgumentMetadata(name: String, help: String, required: Boolean/*, argType: Class[_]*/)
