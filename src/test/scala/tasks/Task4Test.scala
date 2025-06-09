package tasks

import org.junit.*
import org.junit.Assert.*
import Task4.Expr
import tasks.Task4.Expr.*

class ExprTest:
  val expr: Expr = Multiply(Literal(20), Add(Literal(2), Literal(3)))

  @Test def literalShouldReturnInt(): Unit =
    assertEquals(evaluate(Literal(10)),  10)

  @Test def correctSum(): Unit =
    val sum = 10 + 5
    assertEquals(evaluate(Add(Literal(10), Literal(5))), sum)

  @Test def correctMultiply(): Unit =
    val mul = 10 * 5
    assertEquals(evaluate(Multiply(Literal(10), Literal(5))), mul)

  @Test def correctAssociativity(): Unit =
    val res = 10 * 5 + 10
    assertEquals(evaluate(Add(Multiply(Literal(10), Literal(5)), Literal(10))), res)
