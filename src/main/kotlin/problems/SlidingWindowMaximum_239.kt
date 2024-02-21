package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxSlidingWindow(intArrayOf(1),1))
}

private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val result = mutableListOf<Int>()
    val oldSet = mutableMapOf<Int, Int>()
    val pq = PriorityQueue<Int>(Comparator { o1, o2 -> o2 - o1 })
    for (i in 0 until k) {
        pq.offer(nums[i])
        oldSet[nums[i]] = (oldSet[nums[i]] ?: 0) + 1
    }
    result.add(pq.peek())
    for (i in k until nums.size) {
        pq.offer(nums[i])
        oldSet[nums[i]] = (oldSet[nums[i]] ?: 0) + 1
        val removedOne = nums[i - k]
        oldSet[removedOne] = (oldSet[removedOne] ?: 0) - 1
        while (pq.isNotEmpty()) {
            val top = pq.peek()
            if ((oldSet[top] ?: 0) > 0) break
            pq.poll()
        }
        result.add(pq.peek())
    }
    return result.toIntArray()
}