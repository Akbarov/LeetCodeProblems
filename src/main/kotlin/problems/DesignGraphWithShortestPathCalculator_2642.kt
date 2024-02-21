package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val graph = Graph(4, arrayOf(intArrayOf(0, 1, 5)))
}

private class Graph(val n: Int, edges: Array<IntArray>) {
    val graph = Array(n) { mutableListOf<IntArray>() }
    var lowCost = Long.MAX_VALUE
    val visited = BooleanArray(n)

    init {
        for (ed in edges) {
            graph[ed[0]].add(intArrayOf(ed[1], ed[2]))
        }
    }

    fun addEdge(edge: IntArray) {
        graph[edge[0]].add(intArrayOf(edge[1], edge[2]))
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        return dijkstra(node1, node2)
    }

    private fun dijkstra(current: Int, target: Int): Int {
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first.compareTo(o2.first) }
        val distances = IntArray(n) { Int.MAX_VALUE }
        distances[current] = 0
        pq.offer(Pair(0, current))
        while (pq.isNotEmpty()) {
            val point = pq.poll()
            val costTillNow = point.second
            val currentPoint = point.first
            if (costTillNow > distances[currentPoint]) continue
            if (currentPoint == target) return costTillNow
            val destinations = graph[currentPoint]
            for (des in destinations) {
                val next = des[0]
                val newCost = des[1] + distances[currentPoint]
                if (distances[next] > newCost) {
                    distances[next] = newCost
                    pq.offer(Pair(newCost, next))
                }
            }
        }
        return if (distances[target] == Int.MAX_VALUE) -1 else distances[target]
    }
}
