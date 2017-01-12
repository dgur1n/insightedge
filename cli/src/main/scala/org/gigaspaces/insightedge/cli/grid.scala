package org.gigaspaces.insightedge.cli

import org.gigaspaces.insightedge.cli.prototype.annotations.{Arg, Command}
import org.gigaspaces.insightedge.cli.prototype.{Command, Module, annotations, moduleRegistry}

import sys.process._

/**
  * @author Danylo_Hurin.
  */
@annotations.Module(help = "Main module to operate with datagrid.")
object grid extends annotations.Module {

  private val IE_HOME = "/home/dgurin/programs/gigaspaces-insightedge-1.0.0-premium"

//  def startDemoMode(): Unit = {
//    s"$IE_HOME/sbin/insightedge.sh --mode demo" !
//  }
//
//  def shutdownDemoMode(): Unit = {
//    s"$IE_HOME/sbin/insightedge.sh --mode shutdown" !
//  }
//
//  def undeploySpace(args: String): Unit = {
//    // --locator localhost:4174
//    s"$IE_HOME/sbin/undeploy-datagrid.sh $args" !
//  }
//
//  def deploySpace(lusId: Int, args: String): Unit = {
//    s"$IE_HOME/sbin/deploy-datagrid.sh $args" !
//  }

  @Command(help = "it stops GSA. It is used for......")
  def gsaStop(@Arg(name = "gsaId", help = "Gsa id is used for....")
              gsaId: String): Unit = {
    println(s"stop gsa id: $gsaId")
  }

  @Command(help = "starts Spark master on specified host. If host is not specified deploys to localhost")
  def sparkStartMaster(@Arg(name = "host", help = "host to start master")
                       host: Option[String] = None,
                       @Arg(name = "args", help = "arguments to start master")
                       args: String): Unit = {
    println(s"starts Spark Master: host=$host, args=$args")
  }


  //  def lusStart(gsaId: Int, lusId: String)
//
//  def lusStop(gsaId: String, lusId: String)
//
//  def gsmStart(gsaId: Int, lusId: String)
//
//  def gsmStop(gsaId: String, gsmId: String)
//
//  def gscStart(gsaId: Int, gscId: String, zones: Array[String])
//
//  def gscStop(gsaId: String, gscId: String)
//
//  def puUndeploy(puId: String)
//
//  def puDeploy(Deployment: Unit = {
//
//  }
}
