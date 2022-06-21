package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestSubarray(intArrayOf(1, 1, 0, 0, 1, 1, 1, 0, 1)))
}

private fun longestSubarray(nums: IntArray): Int {
    var i = 0
    var j = 0
    var k = 1
    while (j < nums.size) {
        if (nums[j] == 0) k--;
        if (k < 0 && nums[i++] == 0) k++
        j++
    }
    return j - i - 1;
}