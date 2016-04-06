package com.gigaspaces.spark.streaming

import com.gigaspaces.spark.implicits._
import com.gigaspaces.spark.rdd.Data
import com.gigaspaces.spark.streaming.implicits._
import com.gigaspaces.spark.utils.{SparkStreaming, Spark, GigaSpaces, GsConfig}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.scalatest.FunSpec
import org.scalatest.concurrent.Eventually._

import scala.collection.mutable
import scala.util.Random

/**
  * @author Oleksiy_Dyagilev
  */
class GigaSpacesStreamingSpec extends FunSpec with GsConfig with GigaSpaces with SparkStreaming {

  it("should save single object from Spark driver") {
    val sc = ssc.sparkContext

    val stream: InputDStream[String] = ssc.queueStream(stringQueue(sc))

    stream.foreachRDD { rdd =>
      val str = rdd.first()
      val data = new Data(Random.nextLong(), str)
      sc.saveToGrid(data)
    }

    ssc.start()

    eventually {
      val savedData = spaceProxy.readMultiple(new Data())
      assert(savedData.length == 1)
    }(timeout(2))
  }

  it("should save multiple objects from Spark driver") {
    val sc = ssc.sparkContext

    val stream: InputDStream[String] = ssc.queueStream(stringQueue(sc))

    stream.foreachRDD { rdd =>
      val stringsArray = rdd.take(2)
      val datas = stringsArray.map(str => new Data(Random.nextLong(), str))
      sc.saveMultipleToGrid(datas)
    }

    ssc.start()

    eventually {
      val savedData = spaceProxy.readMultiple(new Data())
      assert(savedData.nonEmpty)
    }(timeout(2))
  }

  it("should save DStream") {
    val sc = ssc.sparkContext

    val stream: InputDStream[String] = ssc.queueStream(stringQueue(sc))

    stream
      .map(str => new Data(Random.nextLong(), str))
      .saveToGrid()

    ssc.start()

    eventually {
      val savedData = spaceProxy.readMultiple(new Data())
      assert(savedData.nonEmpty)
    }(timeout(2))
  }

  def stringQueue(sc: SparkContext) = {
    val q = mutable.Queue[RDD[String]]()
    q += sc.makeRDD(Seq("aa", "bb", "cc"))
    q += sc.makeRDD(Seq("dd", "ee", "ff"))
    q
  }

}