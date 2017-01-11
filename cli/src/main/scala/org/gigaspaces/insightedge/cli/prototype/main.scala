package org.gigaspaces.insightedge.cli.prototype

import org.gigaspaces.insightedge.cli.grid

import sys.process._

/**
  * @author Vitaliy_Zinchenko
  */
object main {

  val ROOT_DIR = "/home/zinjvi/projects/GS/CLI/insightedge/cli/src/main/resources"

  def main(command: Array[String]): Unit = {
//    val command = Array("grid-gsaStopXXX", "--gsaId=myGsaId-123123213")
    val commandData = parser.parse(command)
    val module = getModule(commandData.module)
    val moduleMetadata = metadataGenerator.moduleMetadata(module)
    if(!validator.isValidCommandName(commandData.command, moduleMetadata)) {
      println(s"wrong command: ${commandData.command}")
      helperGenerator.generate(moduleMetadata)
      return
    }

    val metadata = metadataGenerator.commandMetadata(module, commandData.command)
    if(!validator.isValidate(commandData, metadata)) {
      helperGenerator.generate(metadata)
      return
    }
    val code = commandToCodeConverter.convert(commandData)
    println(s"code >>> $code")
    run(code)
  }

  def getModule(module: String): Any = module match {
    case "grid" => grid
  }

  def run(code: String) = {
    s"$ROOT_DIR/cli.sh -c $code" !
  }

}
