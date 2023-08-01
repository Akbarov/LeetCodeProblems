package problems

import kotlin.math.abs

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minimumAverageDifference(intArrayOf(4, 2, 0)))
}

private fun minimumAverageDifference(nums: IntArray): Int {
    var rightSum = 0L
    nums.forEach { rightSum += it }
    var leftSum = 0L
    val n = nums.size
    var difMin = Long.MIN_VALUE
    var index = 0
    for ((i, item) in nums.withIndex()) {
        leftSum += item
        rightSum -= item
        val temp = abs(leftSum / (i + 1) - rightSum / (if ((n - i - 1) == 0) 1 else n - i - 1))
        if (temp < difMin) {
            difMin = temp
            index = i
        }
    }
    return index
}