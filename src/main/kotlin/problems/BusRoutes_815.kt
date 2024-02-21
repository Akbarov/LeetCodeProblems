package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(numBusesToDestination(arrayOf(intArrayOf(1, 2, 7), intArrayOf(3, 6, 7)), 1, 6))
}

private fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    for ((i, array) in routes.withIndex()) {
        for (item in array) {
            if (graph[item] == null) {
                graph[item] = mutableSetOf()
            }
            graph[item]?.add(i)
        }
    }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(Pair(source, 0))
    val seenSet = mutableSetOf<Int>()
    val seenRoutes = BooleanArray(routes.size)
    seenSet.add(source)
    while (queue.isNotEmpty()) {
        val rout = queue.poll()
        val nextRout = rout.first
        val cost = rout.second
        if (nextRout == target) return cost
        graph[nextRout]?.forEach { i ->
            if (!seenRoutes[i]) {
                for (next in routes[i]) {
                    if (next !in seenSet) {
                        queue.offer(Pair(next, cost + 1))
                        seenSet.add(next)
                    }
                }
            }
            seenRoutes[i] = true
        }
    }
    return -1
}
