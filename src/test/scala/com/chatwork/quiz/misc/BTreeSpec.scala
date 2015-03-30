package com.chatwork.quiz.misc

import org.scalatest.{Matchers, FunSpec}

import scala.math.Ordering.IntOrdering

class BTreeSpec extends FunSpec with Matchers  {

  implicit val i = new Fractional[Int] with IntOrdering {
    override def div(x: Int, y: Int): Int = x / y

    override def toDouble(x: Int): Double = x.toDouble

    override def toFloat(x: Int): Float = x.toFloat

    override def toLong(x: Int): Long = x.toLong

    override def toInt(x: Int): Int = x

    override def fromInt(x: Int): Int = x

    override def negate(x: Int): Int =  x

    override def times(x: Int, y: Int): Int = x * y

    override def minus(x: Int, y: Int): Int = x - y

    override def plus(x: Int, y: Int): Int =  x + y
  }

  implicit def toBigDecimal(n: Int): scala.math.BigDecimal = scala.math.BigDecimal(n)

  describe("BTree#size") {
    it("should return the number of elements in the BTree") {
      BTree(Branch(Leaf(1), 2, Leaf(3))).size shouldBe 3
      BTree(Leaf(1)).size shouldBe 1
    }
  }

  describe("BTree#max") {
    it("should return the max value in the BTree") {
      BTree(Branch(Leaf(1), 2, Leaf(3))).max shouldBe 3
    }
  }

  describe("BTree#min") {
    it("should return the min value in the BTree") {
      BTree(Branch(Leaf(1), 2, Leaf(3))).min shouldBe 1
    }
  }

  describe("BTree#sum") {
    it("should return the sum of values in the BTree") {
      BTree(Branch(Leaf(1), 2, Leaf(3))).sum shouldBe 6
    }
  }

  describe("BTree#avg") {
    it("should return the average of values in the BTree") {
      BTree(Branch(Leaf(1), 2, Leaf(3))).avg shouldBe 2.0d
    }
  }
  
  describe("BTree#find") {
    it("should return a node has the value in the BTree") {
      BTree(Branch(Leaf(1), 2, Leaf(3))).find(1) shouldBe Some(Leaf(1))
    }
  }

  describe("BTree#apply") {
    it("should return a new BTree from List[Int]") {
      BTree(List(1, 2, 3)) shouldEqual BTree(Branch(Leaf(1), 2, Leaf(3)))
    }
  }

}
