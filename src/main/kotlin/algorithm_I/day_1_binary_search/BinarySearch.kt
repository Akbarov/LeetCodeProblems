package algorithm_I.day_1_binary_search

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
}

fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
        val mid = (start + end) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return -1
}