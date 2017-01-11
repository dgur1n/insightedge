package org.gigaspaces.insightedge.cli.prototype

import org.gigaspaces.insightedge.cli.grid

/**
  * @author Vitaliy_Zinchenko
  */
object helperGenerator {

  def generate(commandMetadata: CommandMetadata) = {
    println(s"${commandMetadata.name} - ${commandMetadata.help}")

    commandMetadata.arguments.foreach{ arg =>
      println(s"${arg.name} - ${arg.help}")
    }
  }

  def generate(moduleMetadata: ModuleMetadata) = {
    println(s"Use one of the commands: ")

    moduleMetadata.methods.foreach{ command =>
      println(s"  - $command")
    }
  }

}
