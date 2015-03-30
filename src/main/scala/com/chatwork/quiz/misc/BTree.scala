package com.chatwork.quiz.misc

sealed trait Node {
  
  val value: Int
 
  val size: Int
  
  val sum: Int
  
  val avg: Double
  
  val max: Int
  
  val min: Int
 
  def find(value: => A): Option[Node]
  
}

case class Branch(left: Node, value: Int, right: Node) extends Node {

  val size: Int = ???
  
  val sum: Int = ???
  
  val avg: Double = ???
  
  val max: Int = ???
  
  val min: Int = ???
 
  def find(value: => A): Option[Node] = ???

}

case class Leaf(value: Int) extends Node {

  val size: Int = ???
  
  val sum: Int = ???
  
  val avg: Double = ???
  
  val max: Int = ???
  
  val min: Int = ???
 
  def find(value: => A): Option[Node] = ???
  
}

case class BTree(node: Node) {

  lazy val size: Int = node.size
  
  lazy val sum: Int = node.sum

  lazy val avg: Double = node.avg
  
  lazy val max: Int = node.max
  
  lazy val min: Int = node.min

  def find(value: Int): Option[Node] = node.find(value)

}

object BTree {

  def apply(list: List[Int]): BTree = ???

}
