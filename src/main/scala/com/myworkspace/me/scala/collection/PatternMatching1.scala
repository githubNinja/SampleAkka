package com.myworkspace.me.scala.collection

/*

traits Expr {
  def eval(e:Any) = this match  {
    case Number(n) =>   n
    case Sum(e1,e2) => e1 + e2
  }

}
*/

case class User(id:Int, name:String, gender:Option[String])

object PatternMatching2 {

  val user1 = User(1, "Kran", Some("Male"))
  val user2 = User(2, "Nicky", Some("Female"))

  private val userMap: Map[Int, User] = Map(1 -> user1, 2 -> user2)
  private val userMap1: Map[Int, String] = Map(1 -> "one", 2 -> "Two")

  def findByUserId(userId:Int):Option[User] = {
     userMap.get(userId)
  }

  def findByUserId1(userId:Int):Option[String] = {
    userMap1.get(userId)
  }

}


object PatternMatching1 extends App {
  def show(e: Expr): String = e match {
    case Number(x) => println("XtoString::" +x.toString)
      x.toString * 9
    case Sum(x, y) => show(x) + ":" + show(y)
  }

  override def main(args: Array[String]) = {
    //println("Show Value::;"+ show(Sum(Number(21), Number(13))))
    //println("Show Value::;"+ show(Number(3)))

    println("Result::"+ PatternMatching2.findByUserId(12).getOrElse(Some("User Not found")))
  }
}
