# mojimoji-jvm

A converter between Japanese hankaku and zenkaku characters.

This project is a clone of [mojimoji](https://github.com/studio-ousia/mojimoji) written with Kotlin.


## Installation


```build.gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
        implementation 'com.github.realglobe-Inc:mojimoji-jvm:0.1'
}
```


## Use
```kotlin
import jp.realglobe.mojimoji.hanToZen

fun main(args: Array<String>) {
    hanToZen("ｱｲｳｴｵ") // -> "アイウエオ"
    hanToZen("ｱｲｳｴｵ", kana = false) // -> "ｱｲｳｴｵ"
}
```
