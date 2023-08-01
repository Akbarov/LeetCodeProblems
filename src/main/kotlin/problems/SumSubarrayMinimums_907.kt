package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(sumSubarrayMins(intArrayOf(3, 1, 2, 4)))
}


private fun sumSubarrayMins(arr: IntArray): Int {
    val mod = 1_000_000_007
    var result = 0
    for (i in arr.indices) {
        var value = arr[i]
        for (j in i until arr.size) {
            value = min(value, arr[j])
            result += value
            result %= mod
        }
    }
    return result
}
