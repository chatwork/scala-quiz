package com.chatwork.quiz.collection

import com.chatwork.quiz.{ MyNone, MyOption, MySome }

sealed trait MyList[+A] {

  // Easy
  def length: Int = this.foldRight(0)((_, z) => z + 1)

  // Normal
  def foldLeft[B](z: B)(f: (B, A) => B): B = this match {
    case MyNil              => z
    case MyCons(head, tail) => tail.foldLeft(f(z, head))(f)
  }

  // 難易度選択制
  // Normal: 条件 - 特にありません、気の向くままに実装してください。
  // Hard:   条件 - foldLeftを使って実装してください。
  def foldRight[B](z: B)(f: (A, B) => B): B = this match {
    case MyNil              => z
    case MyCons(head, tail) => f(head, tail.foldRight(z)(f))
  }

  // Normal
  // scalastyle:off
  def ::[B >: A](b: B): MyList[B] = this match {
    case MyNil        => MyList(b)
    case MyCons(_, _) => MyCons(b, this)
  }
  // scalastyle:on

  // Normal
  def reverse: MyList[A] = this.foldLeft(MyNil: MyList[A])((z, item) => MyCons(item, z))

  // Normal
  // scalastyle:off
  def ++[B >: A](b: MyList[B]): MyList[B] = this match {
    case MyNil        => this
    case MyCons(_, _) => this.foldRight(b)((item, z) => MyCons(item, z))
  }
  // scalastyle:on

  // Normal
  def map[B](f: A => B): MyList[B] = this.foldRight(MyNil: MyList[B])((item, z) => MyCons(f(item), z))

  // Normal
  def flatMap[B](f: A => MyList[B]): MyList[B] = this.foldRight(MyNil: MyList[B])((item, z) => f(item) ++ z)

  // Normal
  def filter(f: A => Boolean): MyList[A] =
    this.foldRight(MyNil: MyList[A])((item, z) => if (f(item)) MyCons(item, z) else z)

  // Normal: 条件 - filterと同様の実装でも構いません。
  // Hard:   条件 - 中間リストを生成しないように実装してください。
  def withFilter(f: A => Boolean): MyList[A] = this.foldRight(MyNil: MyList[A])((b, z) => if (f(b)) MyCons(b, z) else z)

  // Normal
  def find(f: A => Boolean): MyOption[A] =
    this.foldRight(MyNone: MyOption[A])((b, z) => if (f(b)) MySome(b) else z)

  // Normal
  def startsWith[B >: A](prefix: MyList[B]): Boolean =
    if (this.length < prefix.length) false
    else
      prefix match {
        case MyNil => true
        case MyCons(pHead, pTail) =>
          this match {
            case MyNil              => false
            case MyCons(head, tail) => if (pHead == head) tail.startsWith(pTail) else false
          }
      }
}

case object MyNil extends MyList[Nothing]

case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {

  // Easy
  def empty[A]: MyList[A] = MyNil

  // Normal
  def apply[A](as: A*): MyList[A] = as.foldRight(MyNil: MyList[A])((b, z) => MyCons(b, z))

}