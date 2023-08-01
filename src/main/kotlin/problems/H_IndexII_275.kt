package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(hIndex(intArrayOf(1, 2, 3, 4, 5)))
    println(hIndex(intArrayOf(1,2,100)))
}

private fun hIndex(citations: IntArray): Int {
    var result = 0
    var left = 0
    var right = citations.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        val temp = min(mid + 1, citations[mid])
        result = max(result, temp)
        if (temp > mid) {
            right = mid - 1
        } else if (temp < mid) {
            left = mid + 1
        }
    }
    return result

}