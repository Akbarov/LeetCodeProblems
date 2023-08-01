package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minFlipsMonoIncr("0101"))
}

private fun minFlipsMonoIncr(s: String): Int {
    var onesCount = 0
    var result = 0
    for (c in s) {
        if (c == '1') {
            onesCount++
        } else {
            result++
            result = min(result, onesCount)
        }
    }
    return result
}