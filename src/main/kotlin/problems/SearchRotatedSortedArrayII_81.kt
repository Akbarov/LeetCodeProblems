package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0))
    println(search(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1), 2))
}

private fun search(nums: IntArray, target: Int): Boolean {
    if (nums.isEmpty()) return false
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (nums[mid] == target) {
            return true
        }
        if (nums[l] == nums[mid] && nums[r] == nums[mid]) {
            l++
            r--
        } else if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) {
                r = mid - 1
            } else
                l = mid + 1
        } else {
            if (nums[mid] < target && nums[r] >= target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
    }
    return false

}