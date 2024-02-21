package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxOperations(intArrayOf(1, 2, 3, 4), 5))
}

private fun maxOperations(nums: IntArray, k: Int): Int {
    nums.sort()
    var left = 0
    var right = nums.lastIndex
    var result = 0

    while (left < right) {
        val sum = nums[left] + nums[right]
        if (sum < k) {
            left++
        } else if (sum > k) {
            right--
        } else {
            result++
            left++
            right--
        }
    }
    return result
}