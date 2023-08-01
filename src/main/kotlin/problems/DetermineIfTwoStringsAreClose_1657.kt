package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(closeStrings("abc", "bca"))
    println(closeStrings("cabbba", "abbccc"))
    println(closeStrings("uau", "ssx"))
}

private fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false
    val first = IntArray(26)
    val second = IntArray(26)
    for (c in word1) {
        first[c - 'a']++
    }
    for (c in word2) {
        second[c - 'a']++
    }
    return first.sortedArray().contentEquals(second.sortedArray())
}