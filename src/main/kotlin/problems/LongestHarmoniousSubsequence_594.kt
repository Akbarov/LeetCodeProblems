package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findLHS(intArrayOf(1, 3, 2, 2, 5, 2, 3, 7)))
}

private fun findLHS(nums: IntArray): Int {
    nums.sort()
    var left = 0
    var right = 0
    var dif = 0
    while (right < nums.size) {
        if (nums[right] - nums[left] == 0) {
            right++
        } else if (nums[right] - nums[left] == 1) {
            if (right - left > dif) dif = right - left+1
            right++
        } else {
            left++
        }
    }
    return dif
}