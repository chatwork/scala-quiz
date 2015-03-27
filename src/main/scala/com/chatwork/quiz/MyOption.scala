package com.chatwork.quiz

sealed trait MyOption[+A]  {

  def get: A

  def isEmpty: Boolean

  def map[B](f: A => B): MyOption[B] = ???

  def flatMap[B](f: A => MyOption[B]): MyOption[B] = ???

  def filter(f: A => Boolean): MyOption[A] = ???

  def getOrElse[B >: A](elseValue: B): B = ???

  def orElse[B >: A](elseValue: => MyOption[B]): MyOption[B] = ???

}

case object MyNone extends MyOption[Nothing] {

  def get = ???

  def isEmpty: Boolean = ???

}

case class MySome[+A](x: A) extends MyOption[A] {

  def get: A = ???

  def isEmpty: Boolean = ???
}

object MyOption {

  def apply[A](x: A): MyOption[A] = ???

}