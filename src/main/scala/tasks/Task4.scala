package tasks

import scala.quoted.Expr

object Task4 extends App:

  def p1 (x:Int)(y:Int)(z:Int) :Boolean = le(x,y) && eq(x,y)

  val le : (Int, Int) => Boolean =  _ <= _

  val eq : (Int, Int) => Boolean = _ == _

  def compose(f:Int => Int, g:Int => Int): Int => Int = (x:Int) => f(g(x))

  val y:Int = compose(_-1, _*2)(5)

  def genericCompose [X,Y,Z] (f: Y => Z, g: X => Y ): X => Z = (x: X) => f(g(x))

  val y2 = genericCompose((x:Int) => x == 5, (x:String) => x.length)("prova")

  def composeThree[A,B,C,D](f: C => D, g: B => C, h: A => B): A => D = (a: A) => f(g(h(a)))

  val res = composeThree((str:String) => str concat "!" , _.toString, (a:Int) => a*2)

  def power(base: Double, exponent: Int): Double = exponent match
    case _ if exponent == 0 => 1
    case _ => base * power(base, exponent - 1)

  def powerTailRec(base:Double, exponent:Int): Double =
    def powerWithAcc(base: Double, exponent:Int, acc: Double): Double = exponent match
      case _ if exponent == 0 => acc
      case _ => powerWithAcc(base, exponent - 1, acc * base)

    powerWithAcc(base, exponent, 1)

  println(powerTailRec(2,3))
  println(power(2,3))


  def reverseNumber(n: Int): Int =
    def reverseNumberWithAcc(n:Int, slicerExp: Int, res: Int): Int = slicerExp match
      case _ if slicerExp > n => res * 10 + n
      case _ => reverseNumberWithAcc(n / 10, slicerExp, res * 10 + (n % slicerExp))

    reverseNumberWithAcc(n, 10, 0)

  println(reverseNumber(54321))


  enum Expr:
    case Literal(n: Int)
    case Add(exprR: Expr, exprL: Expr)
    case Multiply(exprR: Expr, exprL: Expr)

  object Expr:

    def evaluate(expr: Expr): Int = expr match
      case Literal(n) => n
      case Add(exp1, exp2) => evaluate(exp1) + evaluate(exp2)
      case Multiply(exp1, exp2) => evaluate(exp1) * evaluate(exp2)