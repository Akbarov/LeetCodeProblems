package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun lastStoneWeight(stones: IntArray): Int {
    val pq = PriorityQueue<Int> { p1, p2 -> p2 - p1 }
    if (stones.size==1) stones[0]
    for (item in stones) {
        pq.add(item)
    }
    while (pq.size>1){
        val first = pq.poll()
        val second = pq.poll()
        if (first != second) {
            pq.offer(first-second)
        }
    }
    return pq.poll()

}