package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(isAlienSorted(arrayOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
}

private fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val letters = IntArray(26)
    order.forEachIndexed { i, c ->
        letters[c - 'a'] = i
    }
    for (i in 0 until words.lastIndex) {
        var flag = false
        for (j in 0 until words[i].length.coerceAtMost(words[i + 1].length)) {
            if (letters[words[i][j] - 'a'] > letters[words[i + 1][j] - 'a']) return false
            if (letters[words[i][j] - 'a'] < letters[words[i + 1][j] - 'a']) {
                flag = true
                break
            }
        }
        if (flag) continue
        if (words[i].length > words[i + 1].length) return false
    }
    return true
}