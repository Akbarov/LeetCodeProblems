package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(searchRecursion(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(searchRecursion(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(searchRecursion(intArrayOf(5), 5))
}

private fun search(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val mid = (left + right) / 2
        if (target == nums[mid]) {
            return mid
        } else if (target > nums[mid]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1

}

private fun searchRecursion(nums: IntArray, target: Int, l: Int = 0, r: Int = nums.lastIndex): Int {
    if (l > r) return -1
    val mid = (l + r) / 2
    return if (nums[mid] == target) {
        mid
    } else if (nums[mid] > target) {
        searchRecursion(nums, target, l, mid - 1)
    } else {
        searchRecursion(nums, target, mid + 1, r)
    }
}
