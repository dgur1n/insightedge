package org.gigaspaces.insightedge.cli.prototype

import org.dmg.pmml.ComparisonMeasure
import org.gigaspaces.insightedge.cli.grid

/**
  * @author Vitaliy_Zinchenko
  */
object metadataGenerator {

  def commandMetadata(module: Any, command: String): CommandMetadata = {
    val method = module.getClass.getMethod(command, classOf[String])

    val methodHelp = method.getAnnotations
      .find(_.isInstanceOf[Command])
      .map(_.asInstanceOf[Command])
      .map(_.help())
      .get

    val args = method.getParameters
      .map(_.getAnnotation(classOf[Arg]))
      .map(annotation => ArgumentMetadata(annotation.name(), annotation.help()))
      .toList

    CommandMetadata(command, methodHelp, args)
  }

  def moduleMetadata(module: Any): ModuleMetadata = {
    val methods = module.getClass.getMethods.filter{ method =>
      method.getAnnotations.exists{ annotation => annotation.annotationType() == classOf[Command]}
    }.map(_.getName)
      .toList

    ModuleMetadata(methods)
  }

}
