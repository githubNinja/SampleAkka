import scala.collection.immutable.{IndexedSeq, Iterable}
import scala.collection.mutable.ListBuffer
/*val l = List(1,2,3)
l.map( x => x *2)
def f(x:Int) = if ( x> 2) Some(x) else None
def func1(x: Int) = if(x >= 1) x * 2
l.map( x => f(x))
val map = Map(1-> "One", 2-> "Two", 3-> "Three")
map.mapValues( x => x * 3 )
val map1 = Map( 1 -> 2,  2 -> 4, 3 -> 6 )
val map2: Iterable[Int] = map1.flatMap(y => f(y._2))
map1.flatMap( b => Some(b._2) )
val numbers = List(1, 2, 3, 4)
numbers.filter {
  i: Int => i % 2 == 0
}*/
val monthlyGranuleMap = scala.collection.mutable.Map.empty[String, String]
monthlyGranuleMap +=  ("value1"  -> "1")
monthlyGranuleMap +=  ("value2"  -> "2")
monthlyGranuleMap +=  ("value3"  -> "3" )
println(s"values ${monthlyGranuleMap.values}")
var tableNames = ListBuffer("StratumModeledGranule201605", "StratumModeledGranule201606", "StratumModeledGranule201607")
val tableNamesMap = scala.collection.mutable.Map( "201609" -> ("StratumModeledGranule" + "201609"))
tableNamesMap += "201610" -> ("StratumModeledGranule" + "201610")
tableNamesMap.toList.head._2
val _2: String = tableNamesMap.head._2
println("Now Map head is ::"+ _2
)

tableNames ++= List(tableNamesMap.head._2)

println("table Name ::"+ tableNames)
println("tablenames:: head ::" + tableNames.size + "and head element is::" + tableNames.last)
//val seq: IndexedSeq[Any] = tableNames +: _2
//println("seq head is ::"+ seq)
//List(tableNamesMap.head._2) ++ tableNames
//println("ableNames::"+ tableNames)



//val list: List[Int] = map2.toList
//map1.flatMap( x => func1(x))





