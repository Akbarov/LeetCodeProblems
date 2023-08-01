package problems

import java.lang.Math.max
import java.lang.Math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    println(singleNonDuplicate(intArrayOf(3,3,7,7,10,11,11)))
}

private fun singleNonDuplicate(nums: IntArray, start: Int = 0, end: Int = nums.lastIndex): Int {
    val mid = start + (end - start) / 2
    println("$start, $end, => $mid")
    if (mid in 1 until end) {
        return if (nums[mid] == nums[mid + 1]) {
            if ((end - mid) % 2 == 0) {
                singleNonDuplicate(nums, min(mid + 2, end), end)
            } else {
                singleNonDuplicate(nums, start, max(mid - 1, start))
            }
        } else if (nums[mid - 1] == nums[mid]) {
            if ((end - mid) % 2 == 1) {
                singleNonDuplicate(nums, min(mid + 1, end), end)
            } else {
                singleNonDuplicate(nums, start, max(mid - 2, start))
            }
        } else {
            nums[mid]
        }
    } else {
        return nums[mid]
    }
}