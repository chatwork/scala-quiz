# ワードカウント

## 1. 問題 (難易度: Easy)

```scala
List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
```

に含まれる、フルーツの数を数える関数 `countWord` を実装してください。

```scala
object WordCounter {

  def countWord(line: String): Map[String, Int] = ???

}
```


```scala
val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")

val result = WordCounter.countWord(lines)

if (result == Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)) {
  println("正解")
} else {
  println("不正解")
}
```


#### 参考

https://gist.github.com/j5ik2o/7210762


## 2. 応用問題 (難易度: Unlimited)

// オーキド博士「ここに5,000個のRFCのテキストファイルがあるじゃろ？」

本物のワードカウントを実装してください。

