package org.gigaspaces.insightedge.cli

/**
  * @author Danylo_Hurin.
  */
object CliTestApp extends App {

//  grid.startDemoMode()
//    grid.shutdownDemoMode()
//    ReflectionInvoker.invoke("--locator 127.0.0.1:4174 --group insightedge --name reflection-space")
//    ReflectionInvoker.invoke("""grid-deploySpace --args="--locator 127.0.0.1:4174 --group insightedge --name reflection-space2"""")

    ReflectionInvoker.invoke(args)
}
