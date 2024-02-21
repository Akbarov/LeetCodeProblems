package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(leastInterval(charArrayOf('A', 'A', 'B', 'B'), 2))
}

private fun leastInterval(tasks: CharArray, n: Int): Int {
    val map = mutableMapOf<Char, Int>()
    for (c in tasks) {
        map[c] = (map[c] ?: 0) + 1
    }
    val priorityQueue = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    val tempQueue = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second.compareTo(o2.second) }
    map.values.forEach { priorityQueue.offer(it) }
    var time = 0
    while (priorityQueue.isNotEmpty() || tempQueue.isNotEmpty()) {
        time++
        if (priorityQueue.isNotEmpty()) {
            val top = priorityQueue.poll()
            if (top > 1) {
                tempQueue.offer(Pair(top - 1, time + n))
            }
        }
        if (tempQueue.isNotEmpty() && tempQueue.peek().second == time) {
            val top = tempQueue.poll()
            priorityQueue.offer(top.first)
        }
    }
    return time
}