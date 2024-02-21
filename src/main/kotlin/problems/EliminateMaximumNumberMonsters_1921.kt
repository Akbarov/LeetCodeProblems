package problems

import java.util.*
import kotlin.math.ceil

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
    val pq = PriorityQueue<Int>()
    for (i in dist.indices) {
        val distance = dist[i]
        val sp = speed[i]
        val timeToArrive = (distance-1)/sp
        pq.offer(timeToArrive)
    }
    var count = 0
    while (pq.isNotEmpty()) {
        if (count > pq.poll()) return count
        count++
    }
    return dist.size
}