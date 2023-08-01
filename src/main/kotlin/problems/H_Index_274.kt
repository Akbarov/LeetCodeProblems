package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun hIndex(citations: IntArray): Int {
    var result = 0
    citations.sort()
    val n = citations.size
    for (i in citations.indices) {
        val m = min(n - i, citations[i])
        result = max(m, result)
    }
    return result

}