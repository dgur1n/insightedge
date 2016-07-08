package com.gigaspaces.spark.rdd

import com.gigaspaces.scala.annotation._
import com.gigaspaces.spark.model.BucketedGridModel

import scala.beans.{BeanProperty, BooleanBeanProperty}

/**
 * Space class for tests
 */
case class BucketedData(
                 @BeanProperty
                 @SpaceId(autoGenerate = true)
                 var id: String,

                 @BeanProperty
                 @SpaceRouting
                 @SpaceProperty(nullValue = "-1")
                 var routing: Long,

                 @BeanProperty
                 var data: String,

                 @BooleanBeanProperty
                 var flag: Boolean
                 ) extends BucketedGridModel {

  def this(routing: Long, data: String) = this(null, routing, data, false)

  def this() = this(-1, null)

  def this(routing: Long) = this(routing, null)
}