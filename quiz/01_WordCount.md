# ワードカウント

## 1. 問題 (難易度: Easy)

```scala
List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
```

に含まれる、フルーツの数を数える関数 `countWords` を[テスト](../src/test/scala/com/chatwork/quiz/misc/WordCounterSpec.scala)がパスするように実装してください。

```scala
object WordCounter {

  def countWords(line: List[String]): Map[String, Int] = ???

}
```

#### テスト

[src/test/scala/com/chatwork/quiz/misc/WordCounterSpec](../src/test/scala/com/chatwork/quiz/misc/WordCounterSpec.scala)


#### 参考

https://gist.github.com/j5ik2o/7210762


## 2. 応用問題 (難易度: Unlimited)

// オーキド博士「ここに5,000個のRFCのテキストファイルがあるじゃろ？」

本物のワードカウントを実装してください。

