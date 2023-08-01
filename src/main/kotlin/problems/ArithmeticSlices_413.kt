package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numberOfArithmeticSlices(intArrayOf(1,2,3,4,5,6)))
    println(numberOfArithmeticSlices(intArrayOf(1,2,3,4)))
}

private var result = 0
private fun numberOfArithmeticSlices(nums: IntArray): Int {
    result = 0
    if (nums.size < 3) return 0
    for (i in nums.indices) {
        for (j in i until nums.size) {
            helper(nums, nums[j] - nums[i], nums[j], 2, j)
        }
    }
    return result

}

private fun helper(nums: IntArray, diff: Int, last: Int, count: Int, index: Int) {
    if (index > nums.size) return
    if (count >= 3) result++
    for (i in index + 1 until nums.size) {
        if (nums[i] - last == diff) {
            helper(nums, diff, nums[i], count + 1, i)
        }else break
    }
}