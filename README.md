# ChatWork Scala Quiz

[![Join the chat at https://gitter.im/chatwork/scala-quiz](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/chatwork/scala-quiz?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[1. ワードカウント問題](quiz/01_WordCount.md)

[2. 2分木問題](quiz/02_BTree.md)

[3. MyOption問題](quiz/03_MyOption.md)

[4. MyList問題](quiz/04_MyList.md)

# Setup

```
brew install sbt
```

# How to Challenge
各問題で用意された`.scala`ファイルを直接編集してください
例) `src/main/scala/com/chatwork/quiz/misc/WordCounter.scala`

動作確認は`sbt run`ではなく、自動テストにて行います。
下記のコマンドを参考に、各問題で用意されたテストを実行してください。

※ sbtは複数コマンドを空白で繋げることができるため、コマンドと引数をセットにして`''`で囲んでください。

```
sbt test:compile
sbt 'testOnly com.chatwork.quiz.misc.WordCounterSpec'
```

または、対話モードに移行すると、スペース区切りで入力ができます。
```
sbt
```

```
testOnly com.chatwork.quiz.misc.WordCounterSpec
```
