package com.chatwork.quiz.collection

import com.chatwork.quiz.{MySome, MyNone}
import org.scalatest.{FunSpec, Matchers}

class MyListSpec extends FunSpec with Matchers {

  describe("MyList") {
    it("apply") {
      MyList(1, 2, 3) shouldEqual MyCons(1, MyCons(2, MyCons(3, MyNil)))
    }
    it("foldLeft") {
      MyList("H", "e", "l", "l", "o").foldLeft("Say ") { _ + _ } shouldEqual "Say Hello"
    }
    it("foldRight") {
      MyList("H", "e", "l", "l", "o").foldRight(" World") { _ + _ } shouldEqual "Hello World"
    }
    it("::") {
      "H" :: MyList("e", "l", "l", "o") shouldEqual MyList("H", "e", "l", "l", "o")
    }
    it("reverse") {
      MyList(1, 2, 3, 4).reverse shouldEqual MyList(4, 3, 2, 1)
    }
    it("++") {
      MyList(1, 2) ++ MyList(3, 4) shouldEqual MyList(1, 2, 3, 4)
    }
    it("map") {
      MyList(1, 2, 3, 4).map(_ * 2) shouldEqual MyList(2, 4, 6, 8)
    }
    it("flatMap") {
      MyList(MyList(1, 2), MyList(3, 4), MyList(5, 6), MyList(7, 8)).flatMap(_.map(_ * 2)) shouldEqual MyList(2, 4, 6, 8, 10, 12, 14, 16)
    }
    it("filter") {
      MyList(1, 2, 3, 4, 5).filter(_ > 3) shouldEqual MyList(4, 5)
    }
    it("find") {
      MyList(1, 2, 3, 4, 5).find(_ == 1) shouldEqual MySome(1)
      MyList(1, 2, 3, 4, 5).find(_ == 6) shouldEqual MyNone
    }
    it("for") {
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
