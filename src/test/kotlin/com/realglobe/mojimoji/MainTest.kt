package com.realglobe.mojimoji

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object MainTest : Spek ({
    val hanKana = """
        ｱｲｳｴｵ
        ｶｷｸｹｺ
        ｻｼｽｾｿ
        ﾀﾁﾂﾃﾄ
        ﾅﾆﾇﾈﾉ
        ﾊﾋﾌﾍﾎ
        ﾏﾐﾑﾒﾓ
        ﾔﾕﾖ
        ﾗﾘﾙﾚﾛ
        ﾜｦﾝ
        ｧｨｩｪｫ
        ｬｭｮ
        ｶﾞｷﾞｸﾞｹﾞｺﾞ
        ｻﾞｼﾞｽﾞｾﾞｿﾞ
        ﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞ
        ﾊﾞﾋﾞﾌﾞﾍﾞﾎﾞ
        ﾊﾟﾋﾟﾌﾟﾍﾟﾎﾟ
    """.trimIndent()
    val zenKana = """
        アイウエオ
        カキクケコ
        サシスセソ
        タチツテト
        ナニヌネノ
        ハヒフヘホ
        マミムメモ
        ヤユヨ
        ラリルレロ
        ワヲン
        ァィゥェォ
        ャュョ
        ガギグゲゴ
        ザジズゼゾ
        ダヂヅデド
        バビブベボ
        パピプペポ
    """.trimIndent()

    val hanAlphabet = """
        abcdefghijklmnopqrstuvwxyz
        ABCDEFGHIJKLMNOPQRSTUVWXYZ
    """.trimIndent()

    val zenAlphabet = """
        ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ
        ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ
    """.trimIndent()

    val hanDigit = "0123456789"
    val zenDigit = "０１２３４５６７８９"

    val hanSymbol = " !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"
    val zenSymbol = "　！”＃＄％＆’（）＊＋，ー．／：；＜＝＞？＠［＼］＾＿‘｛｜｝〜"

    val hanAll = "ｱｲｳabc0123!#"
    val zenAll = "アイウａｂｃ０１２３！＃"

    given("hanToZen") {
        val shouldPredicate = "should be converted to zenkaku. "
        on("hankaku Katakana") {
            it(shouldPredicate) {
                assertEquals(zenKana, hanToZen(hanKana))
            }
        }
        on("hankaku alphabet") {
            it(shouldPredicate) {
                assertEquals(zenAlphabet, hanToZen(hanAlphabet))
            }
        }
        on("hankaku digit") {
            it(shouldPredicate) {
                assertEquals(zenDigit, hanToZen(hanDigit))
            }
        }
        on("hankaku symbol") {
            it(shouldPredicate) {
                assertEquals(zenSymbol, hanToZen(hanSymbol))
            }
        }
        on ("call with kana=false") {
            it("should not convert kana. ") {
                assertEquals("ｱｲｳａｂｃ０１２３！＃", hanToZen(hanAll, kana = false))
            }
        }
        on ("call with ascii=false") {
            it("should only convert kana. ") {
                assertEquals("アイウabc0123!#", hanToZen(hanAll, ascii = false))
            }
        }
        on("call with alphabet=false") {
            it("should not convert alphabet") {
                assertEquals("アイウabc０１２３！＃", hanToZen(hanAll, alphabet = false))
            }
        }
        on ("call with digit=false") {
            it("should not convert digit. ") {
                assertEquals("アイウａｂｃ0123！＃", hanToZen(hanAll, digit = false))
            }
        }
        on ("call with symbol=false") {
            it("should not convert symbol. ") {
                assertEquals("アイウａｂｃ０１２３!#", hanToZen(hanAll, symbol = false))
            }
        }
    }

})
