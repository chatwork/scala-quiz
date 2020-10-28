package com.chatwork.quiz.collection

import com.chatwork.quiz.MyOption

sealed trait MyList[+A] {

  // Easy
  def length: Int = this match {
    case MyNil         => 0
    case MyCons(x, xs) => 1 + xs.length
  }

  // Normal
  def foldLeft[B](z: B)(f: (B, A) => B): B = this match {
    case MyNil => z
    case MyCons(x, xs) => {
      val result = f(z, x)
      xs.foldLeft(result)(f)
    }
  }

  // 難易度選択制
  // Normal: 条件 - 特にありません、気の向くままに実装してください。
  // Hard:   条件 - foldLeftを使って実装してください。
  def foldRight[B](z: B)(f: (A, B) => B): B = this match {
    case MyNil => z
    case MyCons(x, xs) => {
      f(x, xs.foldRight(z)(f))
    }
  }

  // Normal
  // scalastyle:off
  def ::[B >: A](b: B): MyList[B] = this match {
    case _ => MyCons(b, this)
  }
  // scalastyle:on

  // Normal
  def reverse: MyList[A] = this match {
    case MyCons(x, xs) => xs.reverse ++ MyList(x)
    case MyNil         => MyNil
  }

  // Normal
  // scalastyle:off
  def ++[B >: A](b: MyList[B]): MyList[B] = {
    def append(x: MyList[B], y: MyList[B]): MyList[B] = x match {
      case MyNil        => x
      case MyCons(h, t) => MyCons(h, t)
    }
    append(this, b)
  }
  // scalastyle:on

  // Normal
  def map[B](f: A => B): MyList[B] =  this match {
    case MyCons(x, xs) => xs.map(f).::(f(x))
    case MyNil         => MyNil
  }

  // Normal
  def flatMap[B](f: A => MyList[B]): MyList[B] = this match {
    case MyCons(x, xs) => xs.flatMap(f).++(f(x))
    case MyNil         => MyNil
  }


  // Normal
  def filter(f: A => Boolean): MyList[A] = this match {
    case MyCons(x, xs) =>
      if (f(x)) {
        xs.filter(f).::(x)
      } else xs.filter(f)
    case MyNil => MyNil
  }

  // Normal: 条件 - filterと同様の実装でも構いません。
  // Hard:   条件 - 中間リストを生成しないように実装してください。
  def withFilter(f: A => Boolean): MyList[A] = filter(f)

  // Normal
  def find(f: A => Boolean): MyOption[A] = ???

  // Normal
  def startsWith[B >: A](prefix: MyList[B]): Boolean = ???

}

case object MyNil extends MyList[Nothing]

case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {

  // Easy
  def empty[A]: MyList[A] = ???

  // Normal
  def apply[A](as: A*): MyList[A] = as match {
    case x +: xs => MyCons(x, MyList(xs: _*))
    case Seq()   => MyNil
  }

}
