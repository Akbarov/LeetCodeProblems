package problems

fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}

private fun majorityElement(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    nums.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    val n = nums.size
    for ((key, value) in map) {
        if (value > n / 2) {
            return key
        }
    }
    return 0
}

private fun majorityElement2(nums: IntArray): Int {
    var cand = 0
    var count = 0
    for (item in nums) {
        if (count == 0) {
            cand = item
        }
        if (cand == item) count++
        else count--
    }
    return cand
}