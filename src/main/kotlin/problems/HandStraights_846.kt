package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(isNStraightHand(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3))
}

private fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
    if (hand.size % groupSize != 0)
        return false
    val priorityQueue = PriorityQueue<Int>()
    hand.forEach {
        priorityQueue.add(it)
    }
    while (priorityQueue.isNotEmpty()) {
        val start = priorityQueue.poll()
        for (i in 1 until groupSize) {
            if (!priorityQueue.remove(start + i)) {
                return false
            }
        }
    }
    return true
}