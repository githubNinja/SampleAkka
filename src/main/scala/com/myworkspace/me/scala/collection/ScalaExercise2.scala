package com.myworkspace.me.scala.collection

case class Foo(name: String, age: Int, sex: String)

object ScalaExercise2 extends App {
  methodSum(List(100, 23, 45))
  nameAgeFunc

  def methodSum(elements: List[Int]): Unit = {
    val left: Int = elements.foldLeft(0) {
      ((a, b) => a + b)
    }
    println("Sum2 is :foldLeft:" + left)
    println("reduceLeft Sum:" + elements.reduceLeft(_ max _))
  }

  def list(): Unit = {
    var average: Double = 0d
    var temp: Int = 0
    val lt = List(25, 15, 10, 5, 0)
    val sum = lt.foldLeft(0) {
      (a1, a2) =>
        //println(s"a1 elements are ${a1}")
        println(s"a2 elements are ${a2}")
        temp = temp + (a2)
        temp
    }
    println(s"sum is ${sum} and average is ${sum / lt.length}")

  }

  case class MeasurementDetail(measurementId: Option[Int])

  def measurementDetails = {
    val apiMeasurements = Seq.empty[MeasurementDetail]
    //Todo fill up the values of Measurement detail....
    apiMeasurements.foldLeft(scala.collection.mutable.Map[Int, MeasurementDetail]()) {
      (measurementId, measurmentDetail) => measurementId += (measurmentDetail.measurementId.get -> measurmentDetail)
    }
  }


  def nameAgeFunc() = {
    val foo = Foo("Hugh Jass", 25, "male")
    val fooList = foo :: Foo("Incontinentia Buttocks", 37, "female") :: Foo("Biggus Dickus", 43, "male") :: Nil
    println("elements of fooList::" + fooList)
    //And we want to turn it into a list of strings in the format of [title] [name], [age]
    val outputList: List[String] = List.empty[String]

    val left: List[String] = fooList.foldLeft(List[String]()) {
      (a, b) => b.sex match {
        case "female" => a :+ s"Mrs ${b.name},${b.age.toString}"
        case "male" => a :+ s"Mr ${b.name},${b.age.toString}"
      }
    }
    println("Left is ::" + outputList)
    println("a is ::" + left(0))
    list()
  }
}

