fun encryptThis(text: String): String {
    val words = Regex(" ").split(text)
    val encryptedWords = words.map {
        val firstLetter = Regex("\\w").find(it)!!.value.single()
        val ascii = firstLetter.toInt().toString()
        val suffix = it.substring(1)
        if (suffix.length < 2) {
            ascii + suffix
        } else ascii + suffix.last() + suffix.substring(1, suffix.length - 1) + suffix.first()
    }
    return encryptedWords.reduce { acc, s -> "$acc $s" }
}

fun encryptThisMoreRegEx(text: String): String {
    return text.split(" ")
            .joinToString(" ") {
                convertFirstLetterToAscii(it) + encryptSuffix(it)
            }
}

private fun convertFirstLetterToAscii(word: String) = word.first().toInt().toString()

private fun encryptSuffix(word: String): String {
    val suffix = word.drop(1)
    return when (suffix.length) {
        0, 1 -> suffix
        else -> {
            val (first, middle, last) = """(^\w)(\w*)(\w$)""".toRegex().find(suffix)!!.destructured
            "$last$middle$first"
        }
    }
}
