package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(lucky(intArrayOf(1, 2, 2, 3, 3, 3)))
    println(lucky(intArrayOf(2, 2, 3, 4)))
    println(lucky(intArrayOf(2, 2, 2, 3, 3)))
    println(lucky(intArrayOf(5)))

}

private fun lucky(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    if (nums.size == 1) {
        return if (nums.first() == 1) 1 else -1
    }
    nums.sortDescending()
    var count = 1
    for (i in 1 until nums.size) {
        if (nums[i - 1] == nums[i]) {
            count++
        } else {
            if (count == nums[i - 1]) {
                return count
            }
            count = 1
        }
    }
    return if (count == nums.last()) count else -1
}