package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(findWords(arrayOf("Hello","Alaska","Dad","Peace")).joinToString())
}

private fun findWords(words: Array<String>): Array<String> {

    val first = setOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')
    val second = setOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')
    val third = setOf('z', 'x', 'c', 'v', 'b', 'n', 'm')
    val list = mutableListOf<String>()
    for (word in words) {
        if (word.isBlank()) continue
        var firstChar = word.first().toLowerCase()
        if (firstChar in first) {
            if (isTheWordInThisSet(word, first)) {
                list.add(word)
            }
        } else if (firstChar in second) {
            if (isTheWordInThisSet(word, second)) {
                list.add(word)
            }
        } else if (firstChar in third) {
            if (isTheWordInThisSet(word, third)) {
                list.add(word)
            }
        }
    }
    return list.toTypedArray()
}

private fun isTheWordInThisSet(word: String, set: Set<Char>): Boolean {
    val temp = word.toLowerCase()
    for (c in temp) {
        if (c !in set) {
            return false
        }
    }
    return true
}