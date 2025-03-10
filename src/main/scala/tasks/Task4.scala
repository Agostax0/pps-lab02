package tasks

object Task4 extends App:
  //val p1: (Int, Int, Int) => Boolean = (x:Int, y:Int, z:Int ) => (x <= y) && (y == z)

  val le : (Int, Int) => Boolean =  _ <= _

  val eq : (Int, Int) => Boolean = _ == _

  val f : ((Int, Int) => Boolean, (Int, Int) => Boolean) => Boolean = _ == _

