package com.chatwork.quiz.misc

/**
  * [[BTree]]に格納される要素。
  */
sealed trait Node {

  /**
    * ノードが持つ値。
    */
  val value: Int

  /**
    * ノード数。
    */
  val size: Int

  /**
    * ノードが保持するすべての値の合計値。
    */
  val sum: Int

  /**
    * ノードが保持するすべての値の平均値。
    */
  val avg: Double

  /**
    * ノードが保持する最大値。
    */
  val max: Int

  /**
    * ノードが保持する最小値。
    */
  val min: Int

  /**
    * 指定した値を保持するノードを検索する。
    *
    * @param value 値
    * @return ノード
    */
  def find(value: Int): Option[Node]

}

/**
  * 枝を表す[[Node]]。
  *
  * @param left　左の[[Node]]
  * @param value 値
  * @param right 右の[[Node]]
  */
case class Branch(left: Node, value: Int, right: Node) extends Node {

  val size: Int = ???

  val sum: Int = ???

  val avg: Double = ???

  val max: Int = ???

  val min: Int = ???

  def find(value: Int): Option[Node] = ???

}

/**
  * 葉を表す[[Node]]。
  *
  * @param value 値
  */
case class Leaf(value: Int) extends Node {

  val size: Int = ???

  val sum: Int = ???

  val avg: Double = ???

  val max: Int = ???

  val min: Int = ???

  def find(value: Int): Option[Node] = ???

}

/**
  * 二分木データ構造。
  *
  * @param node 頂点のノード
  */
case class BTree(node: Node) {

  lazy val size: Int = node.size

  lazy val sum: Int = node.sum

  lazy val avg: Double = node.avg

  lazy val max: Int = node.max

  lazy val min: Int = node.min

  def find(value: Int): Option[Node] = node.find(value)

}

/**
  * [[BTree]]のコンパニオンオブジェクト。
  */
object BTree {

  /**
    * ファクトリメソッド。
    *
    * @param values ノードに格納する値の集合
    * @return [[BTree]]
    */
  def apply(values: List[Int]): BTree = ???

}
