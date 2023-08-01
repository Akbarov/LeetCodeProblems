package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numSubseq(intArrayOf(3, 5, 6, 7), 9))
    println(numSubseq(intArrayOf(3, 3, 6, 8), 10))
}

private val MOD = 1_000_000_000 + 7
private fun numSubseq(nums: IntArray, target: Int): Int {
    nums.sort()
    var totalCount = 0
    val power = IntArray(nums.size)
    power[0] = 1
    for (i in 1 until nums.size) {
        power[i] = (power[i - 1] * 2) % MOD
    }
    for (i in nums.indices) {
        val right = binarySearch(nums, target - nums[i]) - 1
        if (right>= i) {
            totalCount += power[right - i]
            totalCount %= MOD
        }
    }

    return totalCount
}

private fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] <= target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return left
}
