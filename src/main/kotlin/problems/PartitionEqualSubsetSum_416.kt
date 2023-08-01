package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(canPartition(intArrayOf(1, 5, 11, 5)))
}

private fun canPartition(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 == 1) return false
    return dfs(nums, 0, 0, sum / 2)
}

private fun dfs(nums: IntArray, i: Int, currentSum: Int, half: Int): Boolean {
    if (currentSum > half || i >= nums.size) return false
    if (currentSum == half) return true
    var result = false
    for (j in i until nums.size) {
        result = result || dfs(nums, j + 1, currentSum + nums[j], half)
    }
    return result
}