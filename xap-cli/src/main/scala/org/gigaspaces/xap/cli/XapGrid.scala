package org.gigaspaces.xap.cli

import org.gigaspaces.cli.core.BaseModule
import org.gigaspaces.cli.core.annotations.{Arg, Command, Module}

/**
  * @author Vitaliy_Zinchenko.
  */
@Module(help = "Main module to operate with datagrid.")
class XapGrid extends BaseModule {

  override def name(): String = "grid" //TODO - is duplicated

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

}
