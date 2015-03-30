# 二分木データ構造 実装問題

以下の前提のもと、下記機能を[テスト](../src/test/scala/com/chatwork/quiz/misc/BTreeSpec.scala)がパスするように実装してください。

<img src="https://dl.dropboxusercontent.com/u/557577/btree.png" alt="diagram" width="50%"/>

- 木にはブランチ(枝)とリーフ(葉)があるものとする。ブランチとリーフをノードとし、以下の型階層を前提とする。型については [こちら](../src/main/scala/com/chatwork/quiz/misc/BTree.scala) を参照してください。

```scala
/**
 * [[BTree]]に格納される要素。
 */
sealed trait Node {

  /**
   * ノードが持つ値。
   */
  val value: Int

  /**
   * ノード数。
   */
  val size: Int

  /**
   * ノードが保持するすべての値の合計値。
   */
  val sum: Int

  /**
   * ノードが保持するすべての値の平均値。
   */
  val avg: Double

  /**
   * ノードが保持する最大値。
   */
  val max: Int

  /**
   * ノードが保持する最小値。
   */
  val min: Int

  /**
   * 指定した値を保持するノードを検索する。
   *
   * @param value 値
   * @return ノード
   */
  def find(value: Int): Option[Node]

}

/**
 * 枝を表す[[Node]]。
 *
 * @param left　左の[[Node]]
 * @param value 値
 * @param right 右の[[Node]]
 */
case class Branch(left: Node, value: Int, right: Node) extends Node {

  val size: Int = ???

  val sum: Int = ???

  val avg: Double = ???

  val max: Int = ???

  val min: Int = ???

  def find(value: Int): Option[Node] = ???

}

/**
 * 葉を表す[[Node]]。
 *
 * @param value 値
 */
case class Leaf(value: Int) extends Node {

  val size: Int = ???

  val sum: Int = ???

  val avg: Double = ???

  val max: Int = ???

  val min: Int = ???

  def find(value: Int): Option[Node] = ???

}

/**
 * 二分木データ構造。
 *
 * @param node 頂点のノード
 */
case class BTree(node: Node) {

  lazy val size: Int = node.size

  lazy val sum: Int = node.sum

  lazy val avg: Double = node.avg

  lazy val max: Int = node.max

  lazy val min: Int = node.min

  def find(value: Int): Option[Node] = node.find(value)

}

/**
 * [[BTree]]のコンパニオンオブジェクト。
 */
object BTree {

  /**
   * ファクトリメソッド。
   *
   * @param values ノードに格納する値の集合
   * @return [[BTree]]
   */
  def apply(values: List[Int]): BTree = ???

}
```

- ブランチは、一つの値と、右と左にノード(ブランチもしくはリーフ)を必ず保持する。つまり、左右対象です。
    - ただし、保持する値の大小関係が 左 < 右 となるようにすること。
- リーフは、必ず一つの値を保持する(値を持たないリーフは存在しない)。
- 値は問題を簡単にするためInt型とする。(任意の型に対応できるようにしてもよい)

0) ノードの値を組み合わせてデータを作成できるようにせよ(必須問題)。

```scala
val bTree1 = BTree(Leaf(1))
val bTree2 = BTree(Branch(Leaf(1), 2, Leaf(3)))
val bTree3 = BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
```

1) すべてのノードの数を計算せよ(必須問題)。

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

#### テスト

[src/test/scala/com/chatwork/quiz/misc/BTreeSpec](../src/test/scala/com/chatwork/quiz/misc/BTreeSpec.scala)

