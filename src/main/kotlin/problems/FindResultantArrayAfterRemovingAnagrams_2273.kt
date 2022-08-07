package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun removeAnagrams(words: Array<String>): List<String> {
    val set = mutableSetOf<Int>()
    for (i in words.indices) {
        if (i in set) continue

        for (j in i + 1 until words.size) {
            if (j in set) continue

        }
    }
    return emptyList()
}