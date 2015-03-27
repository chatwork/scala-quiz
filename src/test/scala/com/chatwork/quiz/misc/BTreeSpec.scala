package com.chatwork.quiz.misc

import org.scalatest.{Matchers, FunSpec}

class BTreeSpec extends FunSpec with Matchers {

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
a
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
      BTree(Branch(Leaf(1), 2, Leaf(3))).avg shouldBe 2
    }
  }

  describe("BTree#apply") {
    it("should return a new BTree from List[Int]") {
      BTree(List(1, 2, 3)) shouldEqual BTree(Branch(Leaf(1), 2, Leaf(3)))
    }
  }

}
