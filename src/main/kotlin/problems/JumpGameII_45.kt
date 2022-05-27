package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(jump(intArrayOf(2, 3, 1, 1, 4)))
    val n = 2

}

private var countMin = 0
private fun jump(nums: IntArray): Int {
    countMin = nums.size
    helper(nums, 0, 0)
    return countMin
}

private fun helper(nums: IntArray, index: Int, count: Int) {
    if (index >= nums.lastIndex) {
        if (count < countMin) countMin = count
        return
    }
    for (i in nums[index] downTo 1) {
        helper(nums, index + i, count + 1)
    }
}