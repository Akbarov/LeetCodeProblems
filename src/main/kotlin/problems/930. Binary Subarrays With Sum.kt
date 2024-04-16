package problems

fun main() {
    println(numSubarraysWithSum(intArrayOf(1, 0, 1, 0), 2))
}

private fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {

    var count = 0
    for (i in nums.indices) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum == goal) count++
            else if (sum < goal) break
        }
    }
    return count
}