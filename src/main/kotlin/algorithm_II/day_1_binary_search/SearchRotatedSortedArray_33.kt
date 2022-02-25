package algorithm_II.day_1_binary_search

fun main() {
    println(search(intArrayOf(3, 4, 5, 6, 7, 0, 1, 2), 0))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
}

private fun search(nums: IntArray, target: Int): Int {
    val pivot = findPivot(nums)
    return when {
        pivot == -1 -> binarySearch(nums, target, 0, nums.lastIndex)
        nums[pivot] == target -> pivot
        nums[0] > target -> binarySearch(nums, target, pivot + 1, nums.lastIndex)
        else -> {
            binarySearch(nums, target, 0, pivot)
        }
    }
}

private fun binarySearch(nums: IntArray, target: Int, l: Int, r: Int): Int {
    var left = l
    var right = r
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] < target) {
            left = mid + 1
        } else if (nums[mid] > target) {
            right = mid - 1
        } else
            return mid
    }
    return -1
}

//4,5,6,7,0,1,2,3
private fun findPivot(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (mid < r && nums[mid] > nums[mid + 1]) {
            return mid
        }
        if (mid > l && nums[mid - 1] > nums[mid]) {
            return mid - 1
        }
        if (nums[mid] <= nums[l]) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return -1
}