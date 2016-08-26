package com.myworkspace.me.scala.collection


object ScalaCollection1 {

  def main(args: Array[String]) = {
    println("ScalaCollection1")

    //List
    val list = List("one", "two", "three")
    list.foreach(println)


    //Map
    val map = Map("name1" -> "Kranthi", "name2" -> "Sam")
    map.toList.foreach(println)


  }
}
