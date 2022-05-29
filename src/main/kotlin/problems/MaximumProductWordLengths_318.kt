package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxProduct(arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
    println(maxProduct(arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd")))
}

private fun maxProduct(words: Array<String>): Int {
    var maxP = 0
    for (i in 0 until words.lastIndex) {
        val outer = BooleanArray(26)
        for (c in words[i]) {
            outer[c - 'a'] = true
        }
        outer@ for (j in 1 + i until words.size) {
            for (c in words[j]) {
                if (outer[c - 'a']) {
                    continue@outer
                }
            }
            if (maxP < words[i].length * words[j].length) {
                maxP = words[i].length * words[j].length
            }
        }
    }
    return maxP
}