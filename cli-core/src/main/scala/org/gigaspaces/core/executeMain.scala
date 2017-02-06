package org.gigaspaces.core

//import org.gigaspaces.insightedge.cli.grid

import scala.sys.process._

/**
  * @author Vitaliy_Zinchenko
  */
object executeMain {

  val ROOT_DIR = "/home/zinjvi/projects/GS/CLI/insightedge/cli/src/main/resources"

  def main(command: Array[String]): Unit = {

//    moduleRegistry.register("grid", grid) // TODO - temporary registration

    val commandData = parser.parse(command).get
    val module = moduleRegistry.getModule(commandData.module.get)
    val moduleMetadata = metadataGenerator.moduleMetadata(module)
    if(!validator.isValidCommandName(commandData.command.get, moduleMetadata)) {
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
