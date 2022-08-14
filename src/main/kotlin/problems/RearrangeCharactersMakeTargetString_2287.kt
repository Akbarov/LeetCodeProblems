package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(rearrangeCharacters("ilovecodingonleetcode", "code"))
}

private fun rearrangeCharacters(s: String, target: String): Int {
    val letters = IntArray(26)
    target.forEach {
        letters[it - 'a']++
    }
    val strArray = IntArray(26)
    s.forEach {
        strArray[it - 'a']++
    }
    var minCount = Int.MAX_VALUE
    for (i in 0 until 26) {
        if (letters[i] > 0) {
            minCount = min(minCount, strArray[i] / letters[i])
        }
    }
    return minCount
}