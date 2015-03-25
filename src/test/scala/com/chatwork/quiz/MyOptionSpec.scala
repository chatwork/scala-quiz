package com.chatwork.quiz

import org.scalatest.{Matchers, FunSpec}

class MyOptionSpec extends FunSpec with Matchers {

  describe("MyOption") {
    it("get") {
      Some(100).get shouldEqual MySome(100).get
      intercept[NoSuchElementException] {
        MyNone.get
      }
    }
    it("isEmpty") {
      Some(100).isEmpty shouldEqual MySome(100).isEmpty
      None.isEmpty shouldEqual MyNone.isEmpty
    }
    it("map") {
      val twice = (n: Int) => n * 2
      MySome(100).map(twice).get shouldEqual Some(100).map(twice).get
    }
    it("flatMap") {
      val twice = (n: Int) => n * 2
      MySome(100).flatMap(e => MySome(twice(e))).get shouldEqual Some(100).flatMap(e => Some(twice(e))).get
    }
    it("filter") {
      val f = (n: Int) => n > 2
      MySome(100).filter(f).get shouldEqual Some(100).filter(f).get
    }
    it("for") {
      val value = Some(Some(100))
      val myValue = MySome(MySome(100))
      val originalResult = for {
        a <- value
        b <- a
      } yield b + 1
      val myResult = for {
        a <- myValue
        b <- a
      } yield b + 1
      myResult.get shouldEqual originalResult.get
    }
    it("getOrElse") {
      MySome(100).getOrElse(200) shouldEqual Some(100).getOrElse(200)
      MyNone.getOrElse(200) shouldEqual None.getOrElse(200)
    }
    it("orElse") {
      MySome(100).orElse(MySome(200)) shouldBe MySome(100)
      MyNone.orElse(MySome(200)) shouldBe MySome(200)
    }
  }

}
