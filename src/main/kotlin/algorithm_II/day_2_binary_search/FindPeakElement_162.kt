package algorithm_II.day_2_binary_search

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findPeakElement2(intArrayOf(1, 2, 3, 4, 5, 6)))
    println(findPeakElement2(intArrayOf(1, 2, 3, 0)))
    println(findPeakElement3(intArrayOf(1, 2, 3, 4, 5, 6)))
}

//O(n) time complexity
private fun findPeakElement(nums: IntArray): Int {
    for (i in 0 until nums.lastIndex) {
        if (nums[i] > nums[i + 1]) {
            return i
        }
    }
    return nums.lastIndex
}

//O(log(n))
private fun findPeakElement2(nums: IntArray): Int {
    return binarySearch(nums, 0, nums.lastIndex)
}

private fun binarySearch(nums: IntArray, l: Int, r: Int): Int {
    if (l == r) return l
    val mid = l + (r - l) / 2
    return if (nums[mid + 1] > nums[mid]) {
        binarySearch(nums, mid + 1, r)
    } else {
        binarySearch(nums, l, mid)
    }
}

//with iteration
private fun findPeakElement3(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    while (l < r) {
        val mid = (r + l) / 2
        if (nums[mid] < nums[mid + 1]) {
            l = mid + 1
        } else {
            r = mid
        }
    }
    return l
}