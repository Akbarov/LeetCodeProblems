package bi_weekly_contest_125

import java.util.PriorityQueue

fun main() {

}

private fun minOperations(nums: IntArray, k: Int): Int {

    nums.sort()
    var prev = -1
    var count = 0
    for (item in nums) {
        if (item>=k)return count
        if (item != prev) {
            prev=item
            count++
        }
    }
    return count
}