package com.gigaspaces.spark.rdd

import com.gigaspaces.scala.annotation._

import scala.beans.BeanProperty

/**
 * Grid class for test purposes
 *
 * @author Oleksiy_Dyagilev
 */
case class GridString(
                       @BeanProperty
                       @SpaceId(autoGenerate = true)
                       var id: String,

                       @BeanProperty
                       var string: String
                       ) {
  def this() = this(null, null)

  def this(string: String) = this(null, string)
}
