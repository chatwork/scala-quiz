package com.chatwork.quiz.misc

/**
  * ワードをカウントするオブジェクト。
  */
object WordCounter {

  /**
    * 文字列から単語数をカウントする。
    *
    * @param words 文字列
    * @return 単語がキー、単語数がヴァリューのマップ
    */
  def countWords(words: List[String]): Map[String, Int] = {
    words
      .flatMap( _.split(" "))
      .foldLeft(Map.empty[String, Int]) { (word, count) => word + ((count, word.getOrElse(count, 0) + 1)) }
  }

}