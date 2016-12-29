package org.gigaspaces.insightedge.cli

import sys.process._

/**
  * @author Danylo_Hurin.
  */
object grid {

  private val IE_HOME = "/home/dgurin/programs/gigaspaces-insightedge-1.0.0-premium"

  def startDemoMode(): Unit = {
    s"$IE_HOME/sbin/insightedge.sh --mode demo" !
  }

  def shutdownDemoMode(): Unit = {
    s"$IE_HOME/sbin/insightedge.sh --mode shutdown" !
  }

  def undeploySpace(args: String): Unit = {
    // --locator localhost:4174
    s"$IE_HOME/sbin/undeploy-datagrid.sh $args" !
  }

  def deploySpace(lus: LookupService, args: String): Unit = {
    s"$IE_HOME/sbin/deploy-datagrid.sh $args" !
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
