package graph

import java.util.LinkedList
import java.util.Queue


fun main() {

}

private fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) return listOf(0)
    val result = mutableListOf<Int>()
    val leafs = IntArray(n)
    val graph = createGraph(n, edges, leafs)
    val queue: Queue<Int> = LinkedList()
    for ((index, item) in leafs.withIndex()) {
        if (item == 1) queue.add(index)
    }
    while (queue.isNotEmpty()) {
        result.clear()
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            result.add(current)
            for (item in graph[current]) {
                leafs[item]--
                if (leafs[item] == 1) {
                    queue.add(item)
                }
            }
        }
    }
    return result
}


private fun createGraph(n: Int, edges: Array<IntArray>, leafs: IntArray): Array<MutableList<Int>> {
    val graph = Array(n) { mutableListOf<Int>() }
    for (ed in edges) {
        graph[ed[0]].add(ed[1])
        graph[ed[1]].add(ed[0])
        leafs[ed[0]]++
        leafs[ed[1]]++
    }
    return graph
}