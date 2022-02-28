package algorithm_II.day_2_binary_search

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findMin(intArrayOf(5, 6, 7, 0, 1, 2)))
    println(findMin(intArrayOf(5, 6, 7)))
}

//,5,6,7,0,1,2]
private fun findMin(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var left = 0
    var right = nums.lastIndex
    while (left < right) {
        var mid = left + (right - left) / 2
        if (mid < right && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1]
        }
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return nums[mid]
        }
        if (nums[mid] < nums[left]) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return nums[0]
}