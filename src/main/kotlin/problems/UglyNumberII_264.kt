package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun nthUglyNumber(n: Int): Int {
    if (n == 1) return 1
    val pQueue: PriorityQueue<Int> = PriorityQueue()
    pQueue.add(1)
    for (i in 1 until n) {
        var temp = pQueue.poll()
        while (pQueue.isNotEmpty() && pQueue.peek() == temp) temp = pQueue.poll()
        pQueue.add(temp * 2)
        pQueue.add(temp * 3)
        pQueue.add(temp * 5)
    }
    return pQueue.poll()

}