package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(canJump(intArrayOf(2, 0, 1, 1, 4)))
//    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
}

private lateinit var dp: BooleanArray

private fun canJump(nums: IntArray): Boolean {
    dp = BooleanArray(nums.size)
    helper(nums, 0)
    return dp.last()
}

private fun helper(nums: IntArray, index: Int) {
    if (index >= nums.lastIndex) {
        dp[dp.lastIndex] = true
        return
    }
    if (dp[index] || dp.last()) return
    val temp = nums[index]
    for (i in temp downTo 1) {
        helper(nums, index + i)
    }
}