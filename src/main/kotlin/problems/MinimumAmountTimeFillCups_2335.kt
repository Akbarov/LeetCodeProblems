package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(fillCups(intArrayOf(1, 4, 2)))
}

private fun fillCups(amount: IntArray): Int {

    val pq = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    amount.forEach { pq.offer(it) }
    var result = 0
    while (pq.size > 1) {
        result++
        val first = pq.poll() - 1
        val second = pq.poll() - 1
        if (first > 0) pq.offer(first)
        if (second > 0) pq.offer(second)
    }
    result += pq.poll()
    return result

}