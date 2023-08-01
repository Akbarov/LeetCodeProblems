package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minStoneSum(intArrayOf(2, 4, 10), 2))
}

private fun minStoneSum(piles: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>(Comparator { o1, o2 -> o2.compareTo(o1) })
    for (pile in piles) {
        pq.add(pile)
    }
    var c = 0
    while (c++ < k) {
        var t = pq.poll()
        t -= t / 2
        pq.add(t)
    }
    return pq.sum()
}