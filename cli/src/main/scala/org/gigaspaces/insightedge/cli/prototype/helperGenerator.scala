package org.gigaspaces.insightedge.cli.prototype

import org.gigaspaces.insightedge.cli.grid

/**
  * @author Vitaliy_Zinchenko
  */
object helperGenerator {

  def generate(commandMetadata: CommandMetadata) = {
    println(
      s"""
         |  Command "${commandMetadata.name}" - ${commandMetadata.help}
         |
         |  Options:
       """.stripMargin)

    commandMetadata.arguments.foreach{ arg =>
      val argRequired = if(arg.required) "required" else "not-required"
      println(s"  --${arg.name} ${" "*(20-arg.name.length)} [$argRequired] ${" "*(20-argRequired.length)}  ${arg.help}")
    }
  }

  def generate(moduleMetadata: ModuleMetadata) = {
    println(s"Use one of the commands: ")

    moduleMetadata.methods.foreach{ command =>
      println(s"  - $command")
    }
  }

}
