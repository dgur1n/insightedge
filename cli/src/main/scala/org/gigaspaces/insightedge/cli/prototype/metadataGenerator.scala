package org.gigaspaces.insightedge.cli.prototype

import java.lang.reflect.Parameter

import org.dmg.pmml.ComparisonMeasure
import org.gigaspaces.insightedge.cli.grid
import org.gigaspaces.insightedge.cli.prototype.annotations.{Arg, Command, Module}

/**
  * @author Vitaliy_Zinchenko
  */
object metadataGenerator {

  def commandMetadata(module: AnyRef, command: String): CommandMetadata = {
    val method = module.getClass.getMethods//(command, classOf[String])
        .find(_.getName == command)
        .get

    val methodHelp = method.getAnnotations
      .find(_.isInstanceOf[Command])
      .map(_.asInstanceOf[Command])
      .map(_.help())
      .get

    val args = method.getParameters
      .map(toArgumentMetadata)
      .toList

    CommandMetadata(command, methodHelp, args)
  }

  private def toArgumentMetadata(param: Parameter): ArgumentMetadata = {
    val required = param.getType != classOf[Option[AnyRef]]
    val argAnnotation = Option(param.getAnnotation(classOf[Arg]))
      .getOrElse(throw new RuntimeException(s"Parameter ${param.getName} should have @${classOf[Arg]} annotation"))

    ArgumentMetadata(argAnnotation.name(), argAnnotation.help(), required)
  }

  def moduleMetadata(module: AnyRef): ModuleMetadata = {
    val help = module.getClass.getAnnotation(classOf[Module]).help()

    val methods = module.getClass.getMethods.filter{ method =>
      method.getAnnotations.exists{ annotation => annotation.annotationType() == classOf[Command]}
    }.map(_.getName)
      .toList

    ModuleMetadata(methods, help)
  }

}
