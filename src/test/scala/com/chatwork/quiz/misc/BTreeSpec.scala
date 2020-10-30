package com.chatwork.quiz.misc

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.math.Ordering.IntOrdering

class BTreeSpec extends AnyFunSpec with Matchers {

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
