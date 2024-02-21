package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun characterReplacement(s: String, k: Int): Int {
    var left = 0
    val letters = IntArray(26)
    var mostFreqCount = 0
    var result = 1
    for ((i, c) in s.withIndex()) {
        letters[c - 'A']++
        mostFreqCount = max(mostFreqCount, letters[c - 'A'])
        val toChangeCount = (i - left + 1) - mostFreqCount
        if (toChangeCount > k) {
            letters[s[left++] - 'A']--
        }
        result = max(result, i - left + 1)
    }
    return result
}
