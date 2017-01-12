package org.gigaspaces.insightedge.cli.prototype

import org.gigaspaces.insightedge.cli.prototype.annotations.{Arg, Command, Module}

import scala.collection.mutable

/**
  * @author Vitaliy_Zinchenko
  */
object moduleRegistry {

  private val modules: mutable.Map[String, AnyRef] = mutable.Map[String, AnyRef]()

  def register(name: String, module: AnyRef) = {
    val validModule = module.getClass.getAnnotations.exists(_.annotationType() == classOf[Module])

    val validCommands = module.getClass.getMethods.exists{ method =>
      val commandMethods = method.getAnnotations.filter(_.annotationType() == classOf[Command]).toList
      if(commandMethods.isEmpty) false
      else {
        !method.getParameters.exists{ param =>
          Some(param.getAnnotation(classOf[Arg])).isEmpty
        }
      }
    }

    if(!validCommands || !validModule) throw new IllegalArgumentException(s"Module should have at least one method with annotated method by @${classOf[Command]}. " +
      s"Provided module name'$name' and object of class ${module.getClass}")

    modules += name -> module
  }

  def getModule(name: String): AnyRef = {
    modules(name)
  }

  def moduleNames: Set[String] = {
    modules.keySet.toSet
  }

}
