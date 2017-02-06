package org.gigaspaces.core

/**
  * @author Vitaliy_Zinchenko
  */
object helpPrinter {

  val cli = "./cli.sh"

//  def generate(moduleMetadata: ModuleMetadata) = {
//    println(s"Use one of the commands: ")
//
//    moduleMetadata.methods.foreach{ command =>
//      println(s"  - $command")
//    }
//  }

  def generateRootHelp(modules: Set[String]): Unit = {
    println(
      s"""
         |  Available modules:
       """.stripMargin)

    modules.foreach{ module =>
      val metadata = metadataGenerator.moduleMetadata(moduleRegistry.getModule(module))
      println(s"   - $module - ${metadata.help}")
    }

    println(
      s"""
         |  Usage:
         |  $cli <module> help                                    - to run help of the specified module
         |  $cli <module>-<command> help                          - to run help of the specified command
         |  $cli <module>-<command> [--<argName>=<argValue>]*     - to run command with parameters
       """.stripMargin)
  }

  def generateModuleHelp(module: String): Unit = {
    val metadata = metadataGenerator.moduleMetadata(moduleRegistry.getModule(module))
    println(
      s"""
         |  Module: $module - ${metadata.help}
       """.stripMargin)

    metadata.methods.foreach{ command =>
      val commandMetadata = metadataGenerator.commandMetadata(moduleRegistry.getModule(module), command)
      println(s"   - $command ${" "*(20-command.length)} - ${commandMetadata.help}")
    }

    println(
      s"""
         |  Usage:
         |  $cli <module>-<command> help                          - to run help of the specified command
         |  $cli <module>-<command> [--<argName>=<argValue>]*     - to run command with parameters
       """.stripMargin)
  }

  def generateCommandHelp(module: String, command: String) = {
    val commandMetadata = metadataGenerator.commandMetadata(moduleRegistry.getModule(module), command)
    println(
      s"""
         |  Command "$command" - ${commandMetadata.help}
         |
         |  Options:
       """.stripMargin)

    commandMetadata.arguments.foreach{ arg =>
      val argRequired = if(arg.required) "required" else "not-required"
      println(s"  --${arg.name} ${" "*(20-arg.name.length)} [$argRequired] ${" "*(20-argRequired.length)}  ${arg.help}")
    }

    println(
      s"""
         |  Usage:
         |  $cli <module>-<command> [--<argName>=<argValue>]*     - to run command with parameters
       """.stripMargin)
  }

}
