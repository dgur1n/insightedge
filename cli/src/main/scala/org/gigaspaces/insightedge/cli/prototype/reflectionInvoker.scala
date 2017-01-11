package org.gigaspaces.insightedge.cli.prototype

import org.gigaspaces.insightedge.cli.grid

import scala.reflect.runtime._

/**
  * @author Danylo_Hurin.
  */
object reflectionInvoker {

//  def invoke(command: String): Unit = {
  def invoke(commandData: CommandData): Unit = {
    if (commandData.args.isEmpty) {
//      grid-startDemoMode --args="--mode demo" --name=qwerty
//      val scriptArgs = args(1).split("=")(1)
//      println(s"Object: $objectName, method: $methodName, args: $scriptArgs")
      val module = getModule(commandData.module)
      val mirror = universe.runtimeMirror(getClass.getClassLoader).reflect(module)
//          val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
//          val mirror = runtimeMirror.reflect(Class.forName(s"org.gigaspaces.insightedge.cli.$objectName"))
      val methodMirror = mirror.symbol.typeSignature.member(universe.newTermName(commandData.command))
//      methodMirror.
//      commandData.args.
//      mirror.reflectMethod(methodMirror.asMethod)(scriptArgs)
    } else {
//      println(s"Object: $objectName, method: $methodName")
//      val mirror = universe.runtimeMirror(getClass.getClassLoader).reflect(grid)
//      val methodMirror = mirror.symbol.typeSignature.member(universe.newTermName(methodName))
//      mirror.reflectMethod(methodMirror.asMethod)()
      throw new NotImplementedError()
    }
  }

  def getModule(module: String): Any = module match {
    case "grid" => grid
  }

}
