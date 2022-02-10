package algorithm_I.day_1_binary_search

fun main() {
        println(searchInsert(intArrayOf(1,3,5,6),7))
        println(searchInsert(intArrayOf(1,3,5,6),5))
}

private fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex
    var result = nums.size
    while (start <= end) {
        val mid = (start + end) / 2
        if (nums[mid] < target) {
            start = mid + 1
        } else {
            result = mid
            end = mid - 1
        }
    }
    return result
}