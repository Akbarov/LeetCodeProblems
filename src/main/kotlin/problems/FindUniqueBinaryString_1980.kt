package problems

import kotlin.math.pow

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findDifferentBinaryString(arrayOf("10", "11")))
    println(findDifferentBinaryString(arrayOf("111", "011", "001")))
}

private fun findDifferentBinaryString(nums: Array<String>): String {
    val numbers = BooleanArray((2.0).pow(nums.size.toDouble()).toInt())
    for (bin in nums) {
        numbers[bin.toInt(2)] = true
    }
    val sb = StringBuilder()
    for ((i, n) in numbers.withIndex()) {
        if (!n) {
            sb.append(i.toString(2).reversed())
            break
        }
    }
    while (sb.length < nums.size) {
        sb.append("0")
    }
    return sb.reversed().toString()
}