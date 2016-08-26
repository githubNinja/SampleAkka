package com.myworkspace.me.scala.collection

import org.scalatest._

object ScalaExercise1 extends App with Matchers {

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }

  val someValue: Option[Double] = Some(20.0)
  val value1 = someValue match {
    case Some(v) ⇒ v
    case None    ⇒ 0.0
  }
  println("value1::"+ value1)

  value1 should be( 20.0)
  val noValue: Option[Double] = None
  private val d: Double = noValue match {
    case Some(v) ⇒ v
    case None ⇒ 0.0
  }
  println("double d::"+ d )
  val value2 = d
  value2 should be( 0.0 )

  val number: Option[Int] = Some(3)
  val noNumber: Option[Int] = None
  val result1 = number.map(_ * 1.5)
  val result2 = noNumber.map(_ * 1.5)

  result1 should be(
    Some(4.5f)
  )
  result2 should be(
    None
  )

  val listTuple  = List((1.1f,2), (3.2f,"hey"), (8,8))
  println("listTuple::"+ listTuple.map(_.productIterator.map(_.toString)).flatten)

  val number3: Option[Int] = Some(3)
  val noNumber1: Option[Int] = None
  val result3 = number3.fold(0)(_ * 3)
  val result4 = noNumber1.fold(0)(_ + number3.get)

  println("result3 ::"+ result3)
  println("result4 ::"+ result4)

  result3 should be(9)
//  result4 should be(10)


  val foldLeftList = List(1,2,3,4)
  println(s"List ${foldLeftList}")

  private val left: Int = foldLeftList.foldLeft(0) {
    (element1, element2) => element1 + element2
  }

  println(s"foldLeftList ${left}")

//Collect and Partition.
  var strings = List.empty[String]
  var ints = List.empty[Int]
  val mixedList = List(1,2,3, "one", "six")

  val (stringList, intList) = mixedList partition  {
    case s: String => true
    case i: Int => false
  }

  println(s"stringList::${stringList} and intList :${intList}")
  val map = Map ( 1 -> "One", 2 -> "Two", "3" -> "2").collect {
    case (k:Int, v:String) => (v)
  }
  println(s"Map ::${map}")

  val xsArray = intList.toArray
  println(s"xsArray intList.toArray:: ${xsArray.length} and ${xsArray.tail}")

  val xsArray1 = List(10,19,28)
  val outputArray = new Array[Int](xsArray1.length)
  xsArray1.copyToArray(outputArray)

  println(s"copyToArray xsArray1 :: ${outputArray.size} and ${outputArray.head}")
  val toArray: Array[Int] = List(1,2,3,4).toArray
  println(s"List ${toArray.head}")

  var listValue = List(1,2,3)
  println(s"ListValue:head:${listValue.head}")
  listValue = listValue.tail
  println(s"ListValue:tail:${listValue.tail}")

}
