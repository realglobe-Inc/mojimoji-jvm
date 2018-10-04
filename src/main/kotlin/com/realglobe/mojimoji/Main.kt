package com.realglobe.mojimoji

fun hanToZen(
        text: String,
        ascii: Boolean = true,
        alpha: Boolean = true,
        digit: Boolean = true,
        symbol: Boolean = true,
        kana: Boolean = true
): String {
    val res = StringBuilder()
    var prev: Char? = null
    text.forEach { c ->
        val alphaValue = HZTable.alpha[c]
        val digitValue = HZTable.digit[c]
        val symbolValue = HZTable.symbol[c]
        val kanaTenPrev = HZTable.kanaTen[prev]
        val kanaMaruPrev = HZTable.kanaMaru[prev]
        val kanaValue = HZTable.kana[c]
        when {
            ascii && alpha && alphaValue != null -> res.append(alphaValue)
            ascii && digit && digitValue != null -> res.append(digitValue)
            ascii && symbol && symbolValue != null -> res.append(symbolValue)
            kana && c == 'ﾞ' &&  kanaTenPrev != null -> {
                res.deleteCharAt(res.length - 1)
                res.append(kanaTenPrev)
            }
            kana && c == 'ﾟ' && kanaMaruPrev != null -> {
                res.deleteCharAt(res.length - 1)
                res.append(kanaMaruPrev)
            }
            kana && kanaValue != null -> res.append(kanaValue)
            else -> res.append(c)
        }
        prev = c
    }
    return res.toString()
}

fun zenToHan(
        text: String,
        ascii: Boolean = true,
        alpha: Boolean = true,
        digit: Boolean = true,
        symbol: Boolean = true,
        kana: Boolean = true
): String {
    val res = StringBuilder()

    text.forEach { c ->
        val alphaValue = ZHTable.alpha[c]
        val digitValue = ZHTable.digit[c]
        val symbolValue = ZHTable.symbol[c]
        val kanaValue = ZHTable.kana[c]
        val kanaTenValue = ZHTable.kanaTen[c]
        val kanaMaruValue = ZHTable.kanaMaru[c]
        when {
            ascii && alpha && alphaValue != null -> res.append(alphaValue)
            ascii && digit && digitValue != null -> res.append(digitValue)
            ascii && symbol && symbolValue != null -> res.append(symbolValue)
            kana && kanaValue != null -> res.append(kanaValue)
            kana && kanaTenValue != null -> {
                res.append(kanaTenValue)
                res.append('ﾞ')
            }
            kana && kanaMaruValue != null -> {
                res.append(kanaMaruValue)
                res.append('ﾟ')
            }
                else -> res.append(c)
        }
    }
    return res.toString()
}
