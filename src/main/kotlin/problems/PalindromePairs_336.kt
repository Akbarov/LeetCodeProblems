package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll"))
    for (item in result) {
        println(item.joinToString())
    }
}

private fun palindromePairs(words: Array<String>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    for (i in words.indices) {
        for (j in i + 1 until words.size) {
            if (isPalindrome(words[i] + words[j])) result.add(listOf(i, j))
            if (isPalindrome(words[j] + words[i])) result.add(listOf(j, i))
        }
    }
    return result
}

private fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.lastIndex
    while (l < r) {
        if (s[l++] != s[r--]) return false

    }
    return true
}