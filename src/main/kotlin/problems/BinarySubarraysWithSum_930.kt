package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numSubarraysWithSum2(intArrayOf(1, 0, 1, 0, 1), 2))
    println(numSubarraysWithSum2(intArrayOf(0,0,0,0,0), 0))
}

private fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    var sum = 0
    var count = 0
    for (i in nums.indices) {
        sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum == goal)
                count++
        }
    }
    return count
}
private fun numSubarraysWithSum2(nums: IntArray, goal: Int): Int {
    val dp = IntArray(nums.size+1)
    nums.all { it>=0 }
    var total = 0
    var sum = 0
    for (item in nums) {
        sum+=item
        val dif = sum-goal
        if (dif >= 0) {
            total+=dp[dif]
        }
        if (sum==goal)total++
        dp[sum]++
    }
    return total
}
