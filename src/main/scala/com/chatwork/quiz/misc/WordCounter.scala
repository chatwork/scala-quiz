package com.chatwork.quiz.misc

import scala.collection.immutable.HashMap

/**
  * ワードをカウントするオブジェクト。
  */
object WordCounter {

  val SEPARATOR = " "

  /**
    * 文字列から単語数をカウントする。
    *
    * @param words 文字列
    * @return 単語がキー、単語数がヴァリューのマップ
    */
  def countWords(words: List[String]): Map[String, Int] = {
    words.map(elm => elm.split(SEPARATOR)).flatten.groupMapReduce(t => t)(_ => 1)((x, y) => x + y)
  }

}