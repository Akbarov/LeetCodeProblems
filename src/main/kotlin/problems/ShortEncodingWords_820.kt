package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minimumLengthEncoding(arrayOf("time", "me", "bell")))
}

private fun minimumLengthEncoding(words: Array<String>): Int {
    if (words.isEmpty()) return 0
    if (words.size == 1) return words[0].length + 1
    val set = words.toHashSet()
    for (w in words) {
        for (i in 1 until w.length) {
            set.remove(w.substring(i))
        }
    }
    var count = 0
    for (item in set) {
        count += item.length + 1
    }
    return count
}