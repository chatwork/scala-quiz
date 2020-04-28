# MyOption型 実装課題

問題を解きながら、MyOption型を[テスト](../src/test/scala/com/chatwork/quiz/MyOptionSpec.scala)がパスするように実装してみましょう。

## 1. MyOptionのコンパニオンオブジェクトとapplyを実装してください (難易度: Easy) 

```scala
object MyOption {
  def apply[A](x: A): MyOption[A]
}
```

## 2. MyOption型にget/getOrElse/isEmptyを実装してください (難易度: Easy)

```scala
sealed trait MyOption[+A]  {
  def get: A
  def getOrElse[B >: A](elseValue: B):B
  def isEmpty: Boolean
}
```

## 3. MyOption型にmap/flatMapを実装してください (難易度: Normal)

```scala
sealed trait MyOption[+A]  {
  def map[B](f: A => B): MyOption[B]
  def flatMap[B](f: A => MyOption[B]): MyOption[B]
  def filter(f: A => Boolean): MyOption[A]
}
```

## 4. MyOption型にorElseメソッドを実装してください (難易度: Normal)

```scala
sealed trait MyOption[+A]  {
  def orElse[B >: A](elseValue: => MyOption[B]): MyOption[B]
```

## 5. MyOption型のコンパニオンオブジェクトに下記を**for式で表現した**メソッドを実装してください (難易度: Normal)

```scala
object MyOption {
  def translateToForComprehensions1: MyOption[Int] = {
    MyOption(1).flatMap { one =>
      MyOption(2).flatMap { two =>
        MyOption(3).map { three =>
          one + two + three
        }
      }
    }
  }
  def translateToForComprehensions2: MyOption[Int] = {
    MyOption(1).flatMap { one =>
      MyOption(-2).withFilter(_ > 0).flatMap { two =>
        MyOption(3).map { three =>
          one + two + three
        }
      }
    }
  }
}
```

### テスト

[src/test/scala/com/chatwork/quiz/MyOptionSpec](../src/test/scala/com/chatwork/quiz/MyOptionSpec.scala)
