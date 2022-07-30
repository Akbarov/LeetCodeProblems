package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(searchRange(intArrayOf(5, 6, 7, 7, 8, 8, 10), 8).joinToString())
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).joinToString())
}

private fun searchRange(nums: IntArray, target: Int): IntArray {

    for (i in nums.indices)
    if (nums.isEmpty()) return intArrayOf(-1, -1)

    var left = 0
    var right = nums.lastIndex
    val result = IntArray(2) { -1 }

    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] < target) {
            left = mid + 1
        } else if (nums[mid] > target) {
            right = mid - 1
        } else {
            result[0] = findBorder(nums, target, left, right, 0)
            result[1] = findBorder(nums, target, left, right, 1)
            return result
        }
    }

    return result
}

private fun findBorder(nums: IntArray, target: Int, l: Int, r: Int, index: Int): Int {
    var left = l
    var right = r
    var result = if (index == 0) l else r
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] < target) {
            left = mid + 1
        } else if (nums[mid] > target) {
            right = mid - 1
        } else {
            result = mid
            if (left == right) return result
            if (index == 0) {
                right = mid-1
            } else {
                left = mid+1
            }

        }
    }
    return result
}









