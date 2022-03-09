package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(deleteAndEarn(intArrayOf(3, 4, 2)))
//    println(deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)))
    println(deleteAndEarn(intArrayOf(1, 1, 1, 2, 4, 5, 5, 5, 6)))
}

private fun deleteAndEarn(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var maxResult = Int.MIN_VALUE
    for (i in 0..nums.lastIndex) {
        val temp = nums[i]
        var sum = 0
        for (j in 0..nums.lastIndex) {
            if (temp != nums[j] - 1 && temp != nums[j] + 1) {
                sum += nums[j]
            }
        }
        if (maxResult < sum) maxResult = sum
    }
    return maxResult
}