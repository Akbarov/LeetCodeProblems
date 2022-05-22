package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
    println(findTargetSumWays(intArrayOf(1), 1))
}

private var count = 0
private fun findTargetSumWays(nums: IntArray, target: Int): Int {
    count = 0
    helper(nums, target, 0, 0)
    return count
}

private fun helper(nums: IntArray, target: Int, index: Int, sum: Int) {
    if (index > nums.size) return
    if (index == nums.size) {
        if (target == sum) count++
        return
    }
    helper(nums, target, index + 1, sum - nums[index])
    helper(nums, target, index + 1, sum + nums[index])
}