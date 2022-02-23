package algorithm_I.day_14_bit_manipulation

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(singleNumber(intArrayOf(2, 2, 1)))
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))
}

private fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (n in nums) {
        result = result xor n
    }
    return result
}