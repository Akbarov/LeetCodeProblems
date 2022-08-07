package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minimumOperations(intArrayOf(1, 5, 0, 3, 5)))
}

private fun minimumOperations(nums: IntArray): Int {
    nums.sort()
    var count = 0
    for (i in nums.indices) {
        if (nums[i] <= 0) continue
        count++
        val n = nums[i]
        for (j in i until nums.size) {
            nums[j] -= n
        }
    }
    return count
}