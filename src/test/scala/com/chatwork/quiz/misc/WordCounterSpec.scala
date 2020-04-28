package com.chatwork.quiz.misc

import org.scalatest.{ FunSpec, Matchers }

class WordCounterSpec extends FunSpec with Matchers {

  describe("WordCounter#countWord") {
    it("should count words") {
      val words = List("apple banana", "orange apple mango", "kiwi papaya orange", "mango orange muscat apple")
      WordCounter.countWords(words) shouldBe Map(
        "banana" -> 1,
        "muscat" -> 1,
        "orange" -> 3,
        "mango"  -> 2,
        "apple"  -> 3,
        "kiwi"   -> 1,
        "papaya" -> 1
      )
    }
  }

}
