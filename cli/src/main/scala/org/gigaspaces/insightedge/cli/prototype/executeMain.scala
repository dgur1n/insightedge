package org.gigaspaces.insightedge.cli.prototype

import sys.process._

/**
  * @author Vitaliy_Zinchenko
  */
object executeMain {

  val ROOT_DIR = "/home/zinjvi/projects/GS/CLI/insightedge/cli/src/main/resources"

  def main(command: Array[String]): Unit = {

//    val command = Array("grid-gsaStop", "--gsaId=myGsaId-123123213")
//    val command = Array("grid-gsaStop2", "--gsaId=myGsaId-123123213")
//    val command = Array("grid-test", "--args=sd")
    val commandData = parser.parse(command)
    val module = moduleRegistry.getModule(commandData.module.get)
    val moduleMetadata = metadataGenerator.moduleMetadata(module)
    if(!validator.isValidCommandName(commandData.command.get, moduleMetadata)) {
      println(s"wrong command: ${commandData.command}")
//      helpPrinter.generateCommandHelp(moduleMetadata)
      return
    }

    val metadata = metadataGenerator.commandMetadata(module, commandData.command.get)
    if(!validator.isValidate(commandData, metadata)) {
//      helpPrinter.generate(metadata)
      return
    }
    val code = commandToCodeConverter.convert(commandData, metadata)
    println(s"code >>> $code")
    run(code)
  }

  def run(code: String) = {
    s"$ROOT_DIR/cli.sh -c $code" !
  }

}
