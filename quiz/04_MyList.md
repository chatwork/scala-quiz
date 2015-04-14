# MyList型 実装課題

問題を解きながら、List型を実装してみましょう。

ScalaのList型は、要素1個の head と 残りのListの tail で構成される、単方向リンクのリストです。

head :: tail は、tailも head :: tail となるので、head :: ( head :: ( head :: 空のList ) のような入れ子構造になります。

他にも下記のような線形リストがScalaには標準のコレクションとして用意されています。
 - mutable.LinkedListはミュータブルな単方向リンクのリスト
 - mutable.DoubleLinkedListは双方向リンクのリスト

## 1. 準備

```
$ git clone https://github.com/chatwork/scala-quiz
```

## 2. MyListのコンパニオンオブジェクトと、empty, applyを実装してください (難易度: Easy, Normal)

 - empty: 空のリストを返すメソッド

```scala
object MyList {

  // Easy
  def empty[A]: MyList[A]

  // Normal
  def apply[A](as: A*): MyList[A]

}
```

## 3. MyList型にlengthを実装してください (難易度: Easy)

```scala
sealed trait MyList[+A] {

  // Easy
  def length: Int

}
```

## 4. MyList型にfoldLeftとfoldRightを実装してください (難易度: Normal)

```scala
sealed trait MyList[+A] {

  // Normal
  def foldLeft[B](z: B)(f: (B, A) => B): B

  // 難易度選択制
  // Normal: 条件 - 特にありません、気の向くままに実装してください。
  // Hard:   条件 - foldLeftを使って実装してください。
  def foldRight[B](z: B)(f: (A, B) => B): B

}
```

## 5. MyList型に下記のメソッドを実装してください (難易度: Normal)

 - :: :引数[B]をリストの先頭に追加する
 - reverse: リストの順序を反転する
 - ++: リスト同士を結合する

```scala
sealed trait MyList[+A] {

  // Normal
  def ::[B >: A](b: B): MyList[B]

  // Normal
  def reverse: MyList[A]

  // Normal
  def ++[B >: A](b: MyList[B]): MyList[B]

}
```

## 6. MyList型に下記のメソッドを実装してください (難易度: Normal)

```scala
sealed trait MyList[+A] {

  // Normal
  def map[B](f: A => B): MyList[B]

  // Normal
  def flatMap[B](f: A => MyList[B]): MyList[B]

  // Normal
  def filter(f: A => Boolean): MyList[A]

  // Normal: 条件 - filterと同様の実装でも構いません。
  // Hard:   条件 - 中間リストを生成しないように実装してください。
  def withFilter(f: A => Boolean): MyList[A]
  
}
```


## 9. MyList型に下記のメソッドを実装してください (難易度: Normal)

MyListの要素を探すメソッド、見つかったらMyOption[A]、見つからなかったならMyNoneを返す

```scala
sealed trait MyList[+A] {

  // Normal
  def find(f: A => Boolean): MyOption[A]

}
```

[src/test/scala/com/chatwork/quiz/collection/MyListSpec](../src/test/scala/com/chatwork/quiz/collection/MyListSpec.scala)
