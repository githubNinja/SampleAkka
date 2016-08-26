package com.myworkspace.me.scala.collection


object MyScalaExample extends App{
  println("Hellow MyScalaExample::::")

  val myList = List(12,2,-1,0,98)

  val (small, big) = myList partition ( _ > 5)
  println("Small:::" + small)
  println("Big:::" + big)



}
