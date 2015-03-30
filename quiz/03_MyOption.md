# MyOption型 実装課題

問題を解きながら、MyOption型をテストがパスするように実装してみましょう。


## 1. MyOption, MySome, MyNoneのtraitを用意しましょう

まずは下記のコードを写経してください。

```scala
sealed trait MyOption[+A]
case object MyNone extends MyOption[Nothing]
case class MySome[+A](x: A) extends MyOption[A]
```

### 1.1 「sealed」について説明してください

例えば、パターンマッチするときに、sealedキーワードをつけているとどんなメリットがありますか？

### 1.2 「+」(型引数の変位指定) について調べてみてください (丸投げ)

## 2. MyOptionのコンパニオンオブジェクトとapplyを実装してください (難易度: Easy) 

```scala
object MyOption {
  def apply[A](x: A): MyOption[A]
}
```

## 3. MyOption型にget/getOrElse/isEmptyを実装してください (難易度: Easy)

```scala
sealed trait MyOption[+A]  {
  def get: A
  def getOrElse[B >: A](elseValue: B):B
  def isEmpty: Boolean
}
```

## 4. MyOption型にmap/flatMapを実装してください (難易度: Normal)

```scala
sealed trait MyOption[+A]  {
  def map[B](f: A => B): MyOption[B]
  def flatMap[B](f: A => MyOption[B]): MyOption[B]
  def filter(f: A => Boolean): MyOption[A]
}
```

## 5. MyOption型にorElseメソッドを実装してください (難易度: Normal)

```scala
sealed trait MyOption[+A]  {
  def orElse[B >: A](elseValue: => MyOption[B]): MyOption[B]
```

### テスト

[src/test/scala/com/chatwork/quiz/MyOptionSpec](../src/test/scala/com/chatwork/quiz/MyOptionSpec.scala)
