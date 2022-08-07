package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))
}

private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val words = paragraph.replace("\\p{Punct}".toRegex(), "").lowercase().split(" ").filter { it.isNotBlank() }
    val bannedSet = banned.toHashSet()
    val map = mutableMapOf<String, Int>()
    for (word in words) {
        if (word !in bannedSet) {
            map[word] = (map[word] ?: 0) + 1
        }
    }
    return map.maxByOrNull { it.value }?.key ?: ""
}