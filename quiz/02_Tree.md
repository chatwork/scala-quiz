# 二分木データ構造をScalaで実装する

以下の前提のもと、下記機能を実現する実装を記述せよ。

<img src="https://dl.dropboxusercontent.com/u/557577/btree.png" alt="diagram" width="50%"/>

- 木にはブランチ(枝)とリーフ(葉)があるものとする。ブランチとリーフをノードとし、以下の型階層を前提とする。

```scala
trait Node {
  // ...
}

case class Branch(...) extends Node {
  // ...
}

case class Leaf(...) extends Node {
  // ...
}

case class BTree(node: Node) {
  // ...
}

```

- ブランチは、一つの値と、右と左にノード(ブランチもしくはリーフ)を必ず保持する。つまり、左右対象です。
    - ただし、保持する値の大小関係が 左 < 右 となるようにすること。
- リーフは、必ず一つの値を保持する(値を持たないリーフは存在しない)。
- 値は問題を簡単にするためInt型とする。(任意の型に対応できるようにしてもよい)

0) ノードの値を組み合わせてデータを作成できるようにせよ(必須問題)

```scala
val bTree1 = BTree(Leaf(1))
val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
```

1) すべてのノードの数を計算せよ

```scala
val bTree = BTree(...)
val size = bTree.size
```

2) すべてのノードが保持する値から、最大値/最小値/合計値/平均値を計算せよ(必須問題)。

```scala
val bTree = BTree(...)
val max: Int = bTree.max
val min: Int = bTree.min
val sum: Int = bTree.sum
val avg: Double = bTree.avg
```

3) すべてのノードが保持する値から、特定の値を持つノードを検索できるようにせよ(必須問題)。

```scala
val bTree = BTree(...)
val node: Option[Node] = bTree.find(1)
```

4) 以下のファクトリメソッドを実装せよ。ただしListはソートされているものとする(任意問題)。

```scala
val bTree = BTree(List(1, 2, 3))
println(bTree) // BTree(Branch(Leaf(1), 2, Leaf(3)))
```

