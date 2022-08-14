package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(findSubstring("barfoothefoobarman", arrayOf("foo", "bar")).joinToString())
    println(findSubstring("barfoofoobarthefoobarman", arrayOf("foo", "bar", "the")).joinToString())

}

private val map = mutableMapOf<String, Int>()
private var k = 0
private var wordSize = 0

private fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (words.isEmpty()) return emptyList()
    k = words.size
    wordSize = words[0].length
    val result = mutableListOf<Int>()
    words.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    for (i in 0..s.length - k * wordSize) {
        if (checkExist(i, s)) {
            result.add(i)
        }
    }
    return result
}

fun checkExist(i: Int, s: String): Boolean {
    val remaining = (map + mapOf()).toMutableMap()
    var wordsUsed = 0
    for (index in i until i + k * wordSize step wordSize) {
        val subString = s.substring(index, index + wordSize)
        if ((remaining[subString] ?: 0) != 0) {
            remaining[subString] = (remaining[subString] ?: 0) - 1
            wordsUsed++
        } else {
            return false
        }
    }
    return wordsUsed == k
}
