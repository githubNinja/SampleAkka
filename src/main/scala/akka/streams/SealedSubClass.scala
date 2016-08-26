package akka.streams

class SealedSubClass1 extends SealedSubClass{

  private val sealedSubClass: SealedSubClass = new SealedSubClass
  sealedSubClass.sealedSubclassMethod

}

object SealedSubClass1 extends  App{

}
