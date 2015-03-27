package com.chatwork.quiz.misc

trait Node {

}

case class Branch(left: Node, value: Int, right: Node) extends Node

case class Leaf(value: Int) extends Node

case class BTree(node: Node) {

  def size: Int = ???
  def sum: Int = ???
  def max: Int = ???
  def min: Int = ???
  def avg: Int = ???

  def find(value: Int): Option[Node] = ???

}

object BTree {

  def apply(list: List[Int]): BTree = ???

}