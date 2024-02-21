package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(sortArray(intArrayOf(5, 4, 3, 2, 1)))
}

private fun sortArray(nums: IntArray): IntArray {
    val pq = PriorityQueue<Int> { o1, o2 -> o1.compareTo(o2) }
    nums.forEach { pq.offer(it) }
    for (i in nums.indices) {
        nums[i] = pq.poll()
    }
    return nums
}