package jp.realglobe.mojimoji


private fun charsFromRange(start: Char, length: Int): Array<Char> {
    return (0 until length).map { start + it }.toTypedArray()
}

private val alphabetHankaku = arrayOf(
        *charsFromRange('A', 26),
        *charsFromRange('a', 26)
)

private val alphabetZenkaku = arrayOf(
        *charsFromRange('Ａ', 26),
        *charsFromRange('ａ', 26)
)

private val digitHankaku = charsFromRange('0', 10)

private val digitZenkaku = charsFromRange('０', 10)

private val symbolHankaku = arrayOf(
        *charsFromRange(' ', 16),
        *charsFromRange(':', 7),
        *charsFromRange('[', 6),
        *charsFromRange('{', 4)
)

private val symbolZenkaku = arrayOf(
        '　', '！', '”', '＃', '＄', '％', '＆', '’', '（', '）', '＊', '＋', '，', 'ー', '．', '／',
        '：', '；', '＜', '＝', '＞', '？', '＠',
        '［', '＼', '］', '＾', '＿', '‘',
        '｛', '｜', '｝', '〜'
)

private val kanaZenkaku = arrayOf(
        'ア', 'イ', 'ウ', 'エ', 'オ',
        'カ', 'キ', 'ク', 'ケ', 'コ',
        'サ', 'シ', 'ス', 'セ', 'ソ',
        'タ', 'チ', 'ツ', 'テ', 'ト',
        'ナ', 'ニ', 'ヌ', 'ネ', 'ノ',
        'ハ', 'ヒ', 'フ', 'ヘ', 'ホ',
        'マ', 'ミ', 'ム', 'メ', 'モ',
        'ヤ', 'ユ', 'ヨ',
        'ラ', 'リ', 'ル', 'レ', 'ロ',
        'ワ', 'ヲ', 'ン',
        'ァ', 'ィ', 'ゥ', 'ェ', 'ォ',
        'ッ', 'ャ', 'ュ', 'ョ',
        '。', '、', '・', '゛', '゜', '「', '」', 'ー'
)

private val kanaHankaku = arrayOf(
        'ｱ', 'ｲ', 'ｳ', 'ｴ', 'ｵ',
        'ｶ', 'ｷ', 'ｸ', 'ｹ', 'ｺ',
        'ｻ', 'ｼ', 'ｽ', 'ｾ', 'ｿ',
        'ﾀ', 'ﾁ', 'ﾂ', 'ﾃ', 'ﾄ',
        'ﾅ', 'ﾆ', 'ﾇ', 'ﾈ', 'ﾉ',
        'ﾊ', 'ﾋ', 'ﾌ', 'ﾍ', 'ﾎ',
        'ﾏ', 'ﾐ', 'ﾑ', 'ﾒ', 'ﾓ',
        'ﾔ', 'ﾕ', 'ﾖ',
        'ﾗ', 'ﾘ', 'ﾙ', 'ﾚ', 'ﾛ',
        'ﾜ', 'ｦ', 'ﾝ',
        'ｧ', 'ｨ', 'ｩ', 'ｪ', 'ｫ',
        'ｯ', 'ｬ', 'ｭ', 'ｮ',
        '｡', '､', '･', 'ﾞ', 'ﾟ', '｢', '｣', 'ｰ'
)

private val kanaTenMap = mapOf(
        'ガ' to 'ｶ', 'ギ' to 'ｷ', 'グ' to 'ｸ', 'ゲ' to 'ｹ' , 'ゴ' to 'ｺ',
        'ザ' to 'ｻ', 'ジ' to 'ｼ', 'ズ' to 'ｽ', 'ゼ' to 'ｾ', 'ゾ' to 'ｿ',
        'ダ' to 'ﾀ', 'ヂ' to 'ﾁ', 'ヅ' to 'ﾂ', 'デ' to 'ﾃ', 'ド' to 'ﾄ',
        'バ' to 'ﾊ', 'ビ' to 'ﾋ', 'ブ' to 'ﾌ', 'ベ' to 'ﾍ','ボ' to 'ﾎ',
        'ヴ' to 'ｳ'
)

private val kanaMaruMap = mapOf(
        'パ' to 'ﾊ', 'ピ' to 'ﾋ', 'プ' to 'ﾌ', 'ペ' to 'ﾍ', 'ポ' to 'ﾎ'
)

object HZTable {
    val alpha = alphabetHankaku.zip(alphabetZenkaku).toMap()
    val digit = digitHankaku.zip(digitZenkaku).toMap()
    val symbol = symbolHankaku.zip(symbolZenkaku).toMap()
    val kanaTen = kanaTenMap.map { it.value to it.key }.toMap()
    val kanaMaru = kanaMaruMap.map { it.value to it.key }.toMap()
    val kana = kanaHankaku.zip(kanaZenkaku).toMap()
}

object ZHTable {
    val alpha = alphabetZenkaku.zip(alphabetHankaku).toMap()
    val digit = digitZenkaku.zip(digitHankaku).toMap()
    val symbol = symbolZenkaku.zip(symbolHankaku).toMap()
    val kanaTen = kanaTenMap
    val kanaMaru = kanaMaruMap
    val kana = kanaZenkaku.zip(kanaHankaku).toMap()
}
