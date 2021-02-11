package com.chatwork.quiz.collection

import com.chatwork.quiz.{ MyNone, MyOption }

sealed trait MyList[+A] {

  // Easy
  def length: Int = foldLeft(0)((acc, _) => acc + 1)

  // Normal
  def foldLeft[B](z: B)(f: (B, A) => B): B = {
    this match {
      case MyNil => z
      case MyCons (h, t) => t.foldLeft(f(z, h))(f)
    }
  }

  // 難易度選択制
  // Normal: 条件 - 特にありません、気の向くままに実装してください。
  // Hard:   条件 - foldLeftを使って実装してください。
  def foldRight[B](z: B)(f: (A, B) => B): B = {
    this match {
      case MyNil => z
      case MyCons (h, t) => f(h, t.foldRight(z)(f))
    }
  }

  // Normal
  // scalastyle:off
  def ::[B >: A](b: B): MyList[B] = MyCons(b, this)
  // scalastyle:on

  // Normal
  def reverse: MyList[A] = this.foldLeft(MyNil: MyList[A])((acc, crr) => crr :: acc)

  // Normal
  // scalastyle:off
  def ++[B >: A](b: MyList[B]): MyList[B] = ???
  // scalastyle:on

  // Normal
  def map[B](f: A => B): MyList[B] = {
    this match {
      case MyNil => MyNil
      case MyCons (h, t) => MyCons(f(h), t.map(f))
    }
  }

  // Normal
  def flatMap[B](f: A => MyList[B]): MyList[B] = ???

  // Normal
  def filter(f: A => Boolean): MyList[A] = {
    this match {
      case MyNil => MyNil
      case MyCons (h, t) => {
        if (f(h)) {
          MyCons(h, t.filter(f))
        } else {
          t.filter(f)
        }
      }
    }
  }

  // Normal: 条件 - filterと同様の実装でも構いません。
  // Hard:   条件 - 中間リストを生成しないように実装してください。
  def withFilter(f: A => Boolean): MyList[A] = {
    this match {
      case MyNil => MyNil
      case MyCons (h, t) => {
        if (f(h)) {
          MyCons(h, t.filter(f))
        } else {
          t.filter(f)
        }
      }
    }
  }

  // Normal
  def find(f: A => Boolean): MyOption[A] = {
    this match {
      case MyNil => MyNone
      case MyCons (h, t) => {
        if (f(h)) {
          MyOption.apply(h)
        } else {
          t.find(f)
        }
      }
    }
  }

  // Normal
  def startsWith[B >: A](prefix: MyList[B]): Boolean = ???

}

case object MyNil extends MyList[Nothing]

case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {

  // Easy
  def empty[A]: MyList[A] = MyNil

  // Normal
  def apply[A](as: A*): MyList[A] = as.foldRight(MyNil: MyList[A])((crr, acc) => MyCons(crr, acc))

}
