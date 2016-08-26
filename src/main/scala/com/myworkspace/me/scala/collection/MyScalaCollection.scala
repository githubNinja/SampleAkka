package com.myworkspace.me.scala.collection

import java.util

import scala.collection.JavaConverters
import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}
import com.myworkspace.me.traits.SampleTrait


object MyScalaCollection  extends App{

  println("Main Method1:MyScalaCollection")
  Console.println("Hey From Console")

  //new MyScalaCollection().scalaJavaConverters

  //new MyScalaCollection().addElementsToList
  private val collection: MyScalaCollection = new MyScalaCollection()
  collection.list

/*
  val exception: Try[Int] = collection.throwException(2)
  println("Exception ::" + exception.isSuccess)


  SampleTrait
*/

  //Array
/*  val numbers = Array(1, 2, 3, 4)
  val first = numbers(0) // read the first element
  numbers(3) = 100 // replace the 4th array element with 100
  val biggerNumbers = numbers.map(_ * 2) // multiply all numbers by two
  for( a <- biggerNumbers) println("Numbers::"+ a)

  var buffer = scala.collection.mutable.ListBuffer[Int]()
  buffer += 2
  println("ListBiffer::"+ buffer)*/


  //new MyScalaCollection().mixedListCollectionAndPartition()
 // new MyScalaCollection().playWithMap()

}

class MyScalaCollection {

  def scalaJavaConverters = {
    import scala.collection.JavaConverters._

    val list: util.List[Int] = Seq(1, 45, 2, 0).asJava
    val scalaSeq = list

    val array = java.util.Arrays.asList(list).toArray()
    array.foreach(println)

  }

  def list = {
    val list = List(1,2,3)
    list.foreach(element => println("Element:::"+ element))

    val ls = List(("a", 1), ("b", 2), ("c", 3))

    ls.foreach{
     case (c, n) =>
        println( n + " "+ c)
      }
  }

  def mixedListCollectionAndPartition()={
    println("mixedListCollection::")
    val list:scala.collection.immutable.List[Any] = List[Any](1,2,3,"as","2bc")
    var ints = List.empty[Int]

//Partition
    val (strings, intValues) = list partition {
      case s: String => true;
      case _ => false 
    }

  println("Strings::" + strings)


   val funnyListInts = List(10,2,56,3,89,1,0,12)

    val (big, small) = funnyListInts partition ( _ > 5)
    println("Small:::" + small)
    println("Big:::" + big)
    //Collect
    list collect  {
      case s:String =>
        println("String Value:"+ s)
      case intValue:Int =>
        println("Int Value:"+ intValue)
        ints :+ intValue
       println("Int Value:"+ ints)
    }

  }

  /*def throwException(x:Int):Try[Int] = {

    if ( x > 0)
      Success(x)
    else
      try{
        Failure(throw new Exception("X >2"))
      }catch {
        case e:Exception =>
      }

  }*/


  def addElementsToList = {
    val exampleList = scala.collection.immutable.List("String2", 23, 45, "String1")
    exampleList +: "Kranthi"
    exampleList collect {

      case string:String =>
      println("String::" + string)
     // exampleList :+ "Kranthi"
        println("exampleList"+ exampleList)

    }
  }

/*  def playWithMap()={
    val listMap = List[Int](1,2,5,89,-1)
    val map = listMap.foldLeft(Map[String, Int]()) { (m, s) => m(s) = s.length }

    val toMap: Map[Nothing, Nothing] = listMap.toMap

   for(mapValue <- toMap){
     println("MapValue::" + mapValue)
   }

  }*/
}


