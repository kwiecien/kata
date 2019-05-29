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