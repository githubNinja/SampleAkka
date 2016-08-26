val list1 = List("121" , "233" , "89")
val list2 = List("221" , "433" , "189")

//list1.toMap.foreach(println(_))

list1.map(mapElement => "key1" -> mapElement )
list1 +: list2
list1 ::: list2