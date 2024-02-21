package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun shortestPathLength(graph: Array<IntArray>): Int {
    val n = graph.size
    val set = mutableSetOf<TripleData>()
    val queue: Queue<TripleData> = LinkedList()
    for (i in 0 until n) {
        val mask = 1.shl(i)
        set.add(TripleData(i, mask, 0))
        queue.offer(TripleData(i, mask, 1))
    }

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current.bitMask == (1.shl(n) - 1)) {
            return current.cost
        }
        val neighbors = graph[current.current]
        for (item in neighbors) {
            var bitMask = current.bitMask
            bitMask = bitMask or (1 shl item)
            val tripleData = TripleData(item, bitMask, 0)
            if (tripleData !in set) {
                queue.offer(TripleData(item, bitMask, current.cost + 1))
                set.add(tripleData)
            }
        }
    }
    return -1
}

private data class TripleData(var current: Int, var bitMask: Int, var cost: Int)