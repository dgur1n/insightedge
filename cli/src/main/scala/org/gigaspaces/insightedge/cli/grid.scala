package org.gigaspaces.insightedge.cli

import org.gigaspaces.insightedge.cli.prototype.BaseModule
import org.gigaspaces.insightedge.cli.prototype.annotations.{Arg, Command, Module}

import sys.process._

/**
  * @author Danylo_Hurin.
  */
@Module(help = "Main module to operate with datagrid.")
object grid extends BaseModule {

  private val IE_HOME = "/home/dgurin/programs/gigaspaces-insightedge-1.0.0-premium"
//  private val IE_HOME = "/home/zinjvi/app/gigaspaces-insightedge-1.0.0-premium"

  override def name(): String = "grid" //TODO - is duplicated

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

  @Command(help = "Stops GSA.")
  def gsaStop(@Arg(name = "gsaId", help = "The Gsa id")
              gsaId: String): Unit = {
    println(s"gsaStop gsaId: $gsaId")
  }

  @Command(help = "Starts lus.")
  def lusStart(@Arg(name = "gsaId", help = "The Gsa id")
               gsaId: Int,
               @Arg(name = "lusId", help = "The Lus id")
               lusId: String): Unit = {
    println(s"lusStart id: $gsaId $lusId")
  }

  @Command(help = "Stops lus.")
  def lusStop(@Arg(name = "gsaId", help = "The Gsa id")
              gsaId: String,
              @Arg(name = "lusId", help = "The Lus id")
              lusId: String): Unit = {
    println(s"lusStop gsaId: $gsaId, lusId: $lusId")
  }

  @Command(help = "Starts gsm.")
  def gsmStart(@Arg(name = "gsaId", help = "The Gsa id")
               gsaId: Int,
               @Arg(name = "lusId", help = "The Lus id")
               lusId: String): Unit = {
    println(s"gsmStart gsaId: $gsaId, lusId: $lusId")
  }

  @Command(help = "Stops gsm.")
  def gsmStop(@Arg(name = "gsaId", help = "The Gsa id")
              gsaId: String,
              @Arg(name = "gsmId", help = "The Gsm id")
              gsmId: String): Unit = {
    println(s"gsmStop gsaId: $gsaId, gsmId: $gsmId")
  }

  @Command(help = "Starts gsc.")
  def gscStart(@Arg(name = "gsaId", help = "The Gsa id")
               gsaId: Int,
               @Arg(name = "gscId", help = "The Gsc id")
               gscId: String,
               @Arg(name = "zones", help = "List of zones")
               zones: Array[String]): Unit = {
    println(s"gscStart gsaId: $gsaId, gscId: $gscId, zones: $zones")
  }

  @Command(help = "Stops gsc.")
  def gscStop(@Arg(name = "gsaId", help = "The Gsa id")
              gsaId: String,
              @Arg(name = "gscId", help = "The Gsc id")
              gscId: String): Unit = {
    println(s"gscStop gsaId: $gsaId, gscId: $gscId")
  }

  @Command(help = "Undeploys PU.")
  def puUndeploy(@Arg(name = "puId", help = "The PU id")
                 puId: String): Unit = {
    println(s"puUndeploy puId: $puId")
  }

  //Insight Edge commands
  @Command(help = "Starts InsightEdge in demo mode")
  def startDemoMode(): Unit = {
    s"$IE_HOME/sbin/insightedge.sh --mode demo" !
  }

  @Command(help = "Shuts down InsightEdge demo mode")
  def shutdownDemoMode(): Unit = {
    s"$IE_HOME/sbin/insightedge.sh --mode shutdown" !
  }

  @Command(help = "Starts Spark master on specified host. If host is not specified deploys to localhost")
  def sparkStartMaster(@Arg(name = "host", help = "host to start master")
                       host: Option[String] = None,
                       @Arg(name = "args", help = "arguments to start master")
                       args: String): Unit = {
    println(s"starts Spark Master: host=$host, args=$args")
  }

  @Command(help = "Stops Spark master.")
  def sparkStopMaster(@Arg(name = "host", help = "host to start master")
                      host: Option[String]): Unit = {
    println(s"sparkStopMaster: host=$host")
  }

  @Command(help = "Stops Spark slave.")
  def sparkStopSlave(@Arg(name = "host", help = "host to start master")
                     host: Option[String]): Unit = {
    println(s"sparkStopSlave: host=$host")
  }

  @Command(help = "Starts zeppelin")
  def zeppelinStart(@Arg(name = "host", help = "host to start master")
                    host: Option[String]): Unit = {
    println(s"zeppelinStart: host=$host")
  }

  @Command(help = "Stops zeppelin")
  def zeppelinStop(@Arg(name = "host", help = "host to start master")
                   host: Option[String]): Unit = {
    println(s"zeppelinStop: host=$host")
  }

}
