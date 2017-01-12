package org.gigaspaces.insightedge.cli.prototype

/**
  * @author Vitaliy_Zinchenko
  */
trait Module {

  def help() = {
    helpMain.help()
  }


  def help(command: String) = {

  }

}
