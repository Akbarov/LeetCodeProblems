package problems
fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(-2, -5,-10,-20)))
}

private fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    var maxSum = Int.MIN_VALUE
    for (item in nums) {
        sum += item
        if (sum > maxSum) maxSum = sum
        if (sum < 0) sum = 0
    }
    return maxSum
}