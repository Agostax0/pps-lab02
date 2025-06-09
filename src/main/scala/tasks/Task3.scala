package tasks

object Task3 extends App :
  def positive(x:Int) : String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val positiveFun: Int => String = positive

  println(positive(4))

  val isEmpty: String => Boolean = _ == ""

  def neg (x:Boolean) : Boolean = !x

  println(isEmpty(""))
  println(isEmpty("a"))

  println(neg(isEmpty("")))
  println(neg(isEmpty("a")))

  def genericNeg[X] ( x: X, f:X => Boolean ) : Boolean = !f(x)