package com.chatwork.quiz

/**
 * 値が存在する・しないの両状態を表すオブジェクト。いわゆるMaybeモナド。
 *
 * @tparam A 値の型
 */
sealed trait MyOption[+A] {

  /**
   * 格納された値を返す。
   *
   * @return 値
   * @throws 値が存在しない場合 NoSuchElementException をスローする
   */
  def get: A

  /**
   * 値がないかどうかを返す。
   *
   * @return 値が存在しない場合はtrue。
   */
  def isEmpty: Boolean

  /**
   * 値が存在する場合に、値の変換を行う。
   *
   * @param f 値を変換するための関数
   * @tparam B 新しい型
   * @return 新しい [[MyOption]]
   */
  def map[B](f: A => B): MyOption[B] = ???

  /**
   * 値が存在する場合に、値の変換を行う。
   *
   * @param f 値を変数するための関数
   * @tparam B 新しい型
   * @return 新しい [[MyOption]]
   */
  def flatMap[B](f: A => MyOption[B]): MyOption[B] = ???

  /**
   * 値が存在する場合に、値をフィルタリングする。
   *
   * @param f フィルターのための述語関数
   * @return 新しい [[MyOption]]
   */
  def filter(f: A => Boolean): MyOption[A] = ???

  /**
   * 格納された値を返す。値がない場合は指定された値を返す。
   *
   * @param elseValue 値がない場合に返す値
   * @tparam B 新しい要素型
   * @return 値
   */
  def getOrElse[B >: A](elseValue: B): B = ???

  /**
   * 値が存在しない場合に、指定した式を評価し返す。
   *
   * @param elseValue 値が存在しない場合に返す式
   * @tparam B 新しい要素型
   * @return elseValueを評価した値
   */
  def orElse[B >: A](elseValue: => MyOption[B]): MyOption[B] = ???

}

/**
 * 値が存在ない場合の[[MyOption]]。
 */
case object MyNone extends MyOption[Nothing] {

  def get: Nothing = ???

  def isEmpty: Boolean = ???

}

/**
 * 値が存在する場合の[[MyOption]]。
 *
 * @param value 値
 * @tparam A 値の型
 */
case class MySome[+A](value: A) extends MyOption[A] {

  def get: A = ???

  def isEmpty: Boolean = ???

}

/**
 * [[MyOption]]のコンパニオンオブジェクト。
 */
object MyOption {

  /**
   * ファクトリメソッド。
   *
   * @param value 値
   * @tparam A 値の型
   * @return [[MyOption]]
   */
  def apply[A](value: A): MyOption[A] = ???

}
