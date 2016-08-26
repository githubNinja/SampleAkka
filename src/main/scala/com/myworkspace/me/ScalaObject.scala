package com.myworkspace.me

import java.io.{BufferedInputStream, FileInputStream}

object ScalaObject extends App{
  val file = "C:\\Kranthi\\Gen4\\protobuf_pieces\\2015_04_22_[15_18]_{e95dbd52-9a01-49cd-a41a-ab0af202c445}.jdl.sessionContext"
  val bis = new BufferedInputStream(new FileInputStream(file))
  val bArray = Stream.continually(bis.read).takeWhile(-1 !=).map(_.toByte).toArray
  println("bArray::" + bArray)

}
