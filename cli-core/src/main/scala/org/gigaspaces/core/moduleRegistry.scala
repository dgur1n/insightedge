package org.gigaspaces.core

import scala.collection.mutable

/**
  * @author Vitaliy_Zinchenko
  */
object moduleRegistry {

  private val modules: mutable.Map[String, AnyRef] = mutable.Map[String, AnyRef]()

  def register(name: String, module: AnyRef) = {
    if(!validModule(module)) {
      throw new IllegalArgumentException(s"Module must have at least one method with annotated method by @${classOf[Command]}. And all arguments must be specified with annotation @${classOf[Arg]}" +
        s"Provided module name '$name' and object of class ${module.getClass}")
    }

    if(!validCommands(module)){
      throw new IllegalArgumentException(s"Module must have at least one method with annotated method by @${classOf[Command]}. " +
        s"Provided module name '$name' and object of class ${module.getClass}")
    }

    modules += name -> module
  }

  private def validModule(module: AnyRef): Boolean = {
    module.getClass.getAnnotations.exists(_.annotationType() == classOf[Module])
  }

  private def validCommands(module: AnyRef): Boolean = {
    module.getClass.getMethods.exists{ method =>
      val commandMethods = method.getAnnotations.filter(_.annotationType() == classOf[Command]).toList
      if(commandMethods.isEmpty) false
      else {
        !method.getParameters.exists{ param =>
          Some(param.getAnnotation(classOf[Arg])).isEmpty
        }
      }
    }
  }

  def getModule(name: String): AnyRef = {
    modules(name)
  }

  def moduleNames: Set[String] = {
    modules.keySet.toSet
  }

}
