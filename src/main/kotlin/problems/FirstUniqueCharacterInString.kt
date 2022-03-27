package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
}

private fun firstUniqChar(s: String): Int {
    val alif = IntArray(26)
    for (c in s) {
        alif[c - 'a']++
    }
    for ((index, c) in s.withIndex()) {
        if (alif[c - 'a'] == 1) return index
    }
    return -1
}
