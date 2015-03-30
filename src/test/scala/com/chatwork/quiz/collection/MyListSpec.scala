package com.chatwork.quiz.collection

import com.chatwork.quiz.{MySome, MyNone}
import org.scalatest.{FunSpec, Matchers}

class MyListSpec extends FunSpec with Matchers {

  describe("MyList#apply") {
    it("should return a new MyList instance") {
      MyList(1, 2, 3) shouldEqual MyCons(1, MyCons(2, MyCons(3, MyNil)))
      MyList() shouldEqual MyNil
    }
  }

  describe("MyList#foldLeft") {
    it("should apply an operator a start value and all elements from left to right") {
      MyList("H", "e", "l", "l", "o").foldLeft("Say ") { _ + _ } shouldEqual "Say Hello"
    }
  }

  describe("MyList#foldRight") {
    it("should apply an operator a start value and all elements from right to left") {
      MyList("H", "e", "l", "l", "o").foldRight(" World") { _ + _ } shouldEqual "Hello World"
    }
  }

  describe("MyList#::") {
    it("should return a new MyList added an element at the beginning of this list") {
      "H" :: MyList("e", "l", "l", "o") shouldEqual MyList("H", "e", "l", "l", "o")
    }
  }

  describe("MyList#reverse") {
    it("should return a new MyList with elements in reversed order") {
      MyList(1, 2, 3, 4).reverse shouldEqual MyList(4, 3, 2, 1)
    }
  }

  describe("MyList#++") {
    it("should return a new MyList with elements appended") {
      MyList(1, 2) ++ MyList(3, 4) shouldEqual MyList(1, 2, 3, 4)
    }
  }

  describe("MyList#map") {
    it("should apply an operator to each element in the list") {
      MyList(1, 2, 3, 4).map(_ * 2) shouldEqual MyList(2, 4, 6, 8)
    }
  }

  describe("MyList#flatMap") {
    it("should apply an operator to each element in the list and flatten") {
      MyList(MyList(1, 2), MyList(3, 4), MyList(5, 6), MyList(7, 8)).flatMap(_.map(_ * 2)) shouldEqual MyList(2, 4, 6, 8, 10, 12, 14, 16)
    }
  }

  describe("MyList#filter") {
    it("should return a new MyList containing elements filtered by the given predicate") {
      MyList(1, 2, 3, 4, 5).filter(_ > 3) shouldEqual MyList(4, 5)
    }
  }

  describe("MyList#find") {
    it("should return the first element of the sequence satisfying a predicate") {
      MyList(1, 2, 3, 4, 5).find(_ == 1) shouldEqual MySome(1)
      MyList(1, 2, 3, 4, 5).find(_ == 6) shouldEqual MyNone
    }
  }

  describe("for comprehension") {
    it("should provide for comprehension") {
      (for {
        suit <- MyList("Diamond", "Heart", "Spade", "Club")
        number <- MyList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
        if suit == "Diamond"
      } yield {
        (suit, number)
      }).length shouldBe 13
    }
  }

}
