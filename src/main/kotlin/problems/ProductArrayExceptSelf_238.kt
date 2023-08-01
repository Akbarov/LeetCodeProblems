package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)
    val leftP = IntArray(nums.size)
    val rightP = IntArray(nums.size)
    leftP[0] = nums[0]
    rightP[n - 1] = nums[n - 1]
    for (i in 1 until n - 1) {
        leftP[i] = leftP[i - 1] * nums[i]
        if (nums[i] == 0) break
    }
    for (i in n - 2 downTo 1) {
        rightP[i] = rightP[i + 1] * nums[i]
        if (nums[i] == 0) break
    }
    for (i in 0 until n) {
        val left = if (i > 0) leftP[i - 1] else 1
        val right = if (i < n - 1) rightP[i + 1] else 1
        result[i] = left * right
    }
    return result
}