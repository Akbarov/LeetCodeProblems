package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(countNicePairs(intArrayOf(42, 11, 1, 97)))
}

private fun countNicePairs(nums: IntArray): Int {
    val reverse = IntArray(nums.size) {
        reverse(nums[it])
    }
    var result = 0
    val mod = 1_000_000_007
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val temp = nums[i] - reverse[i]
        map[temp] = (map[temp] ?: 0) + 1
    }
    for (i in nums.indices) {
        val temp = nums[i] - reverse[i]
        result += ((map[temp] ?: 0)-1)
        map[temp] = (map[temp] ?: 1) - 1
        result %= mod
    }
    return result
}

private fun reverse(number: Int): Int {
    var result = 0
    var t = number
    while (t > 0) {
        result *= 10
        result += t % 10
        t /= 10
    }
    return result
}