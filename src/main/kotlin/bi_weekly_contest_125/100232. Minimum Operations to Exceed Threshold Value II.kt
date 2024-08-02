package bi_weekly_contest_125

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min


fun main() {

}

private fun minOperations(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Long> { o1, o2 -> o1.compareTo(o2) }
    for (item in nums) {
        pq.add(item.toLong())
    }
    var count = 0
    while (pq.size > 1) {
        val first = pq.poll()
        val second = pq.poll()
        if (first >= k) return count
        val result = min(first, second) * 2 + max(first, second)
        pq.add(result)
        count++
    }
    return count
}