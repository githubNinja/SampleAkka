package akka.streams

sealed class SealedClassExample {
  
  def sealedClassMethod = {
    println("sealedMethod")
  }

}

class SealedSubClass extends SealedClassExample{

  def sealedSubclassMethod = {
    println("sealedMethod")
  }
}

