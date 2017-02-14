package org.gigaspaces.insightedge.cli

import org.gigaspaces.cli.core.CliModule
import org.gigaspaces.cli.core.annotations.{Arg, Command, Module}
import org.gigaspaces.xap.cli.XapGrid

import sys.process._

/**
  * @author Vitaliy_Zinchenko
  */
@Module(help = "Main module to operate with datagrid.", priority = 1)
class IeGrid extends XapGrid with CliModule {

  override def name(): String = "grid"

//  private val IE_HOME = "/home/dgurin/programs/gigaspaces-insightedge-1.0.0-premium"
  private val IE_HOME = "/home/zinjvi/app/gigaspaces-insightedge-1.0.0-premium"

//  override def name(): String = "grid" //TODO - is duplicated

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

