package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1)))
    println(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1, 4, 2)))
}

private fun findShortestSubArray(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (item in nums) {
        map[item] = (map[item] ?: 0) + 1
    }
    val maxCount = map.values.maxOrNull() ?: 0
    val set = map.filter { it.value == maxCount }.keys
    var result = nums.size
    for (n in set) {
        var first = 0
        for (i in nums.indices) {
            if (nums[i] == n) {
                first = i
                break
            }
        }
        var last = 0
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] == n) {
                last = i
                break
            }
        }
        if (result > last - first + 1) result = last - first + 1
    }
    return result

}