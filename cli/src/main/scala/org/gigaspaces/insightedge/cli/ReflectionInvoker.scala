package org.gigaspaces.insightedge.cli

import scala.reflect.runtime._

/**
  * @author Danylo_Hurin.
  */
object ReflectionInvoker {

//  def invoke(command: String): Unit = {
  def invoke(args: Array[String]): Unit = {
    val objectName = args(0).split("-")(0)
    val methodName = args(0).split("-")(1)
    if (args.length > 1) {
      grid-startDemoMode --args="--mode demo" --name=qwerty
      val scriptArgs = args(1).split("=")(1)
      println(s"Object: $objectName, method: $methodName, args: $scriptArgs")
      val mirror = universe.runtimeMirror(getClass.getClassLoader).reflect(grid)
      //    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
      //    val mirror = runtimeMirror.reflect(Class.forName(s"org.gigaspaces.insightedge.cli.$objectName"))
      val methodMirror = mirror.symbol.typeSignature.member(universe.newTermName(methodName))
      methodMirror.
      mirror.reflectMethod(methodMirror.asMethod)(scriptArgs)
    } else {
      println(s"Object: $objectName, method: $methodName")
      val mirror = universe.runtimeMirror(getClass.getClassLoader).reflect(grid)
      val methodMirror = mirror.symbol.typeSignature.member(universe.newTermName(methodName))
      mirror.reflectMethod(methodMirror.asMethod)()
    }
  }

}
