package problems

import java.util.*
import kotlin.math.min


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), arrayOf()).joinToString())
    println(shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(2, 1))).joinToString())
    println(
        shortestAlternatingPaths(
            3,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)),
            arrayOf(intArrayOf(1, 0))
        ).joinToString()
    )
}

private fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
    if (n <= 0) return intArrayOf()
    val answer = IntArray(n) { Int.MAX_VALUE }
    val graph = Array<Array<MutableSet<Int>>>(2) { Array(n) { mutableSetOf() } }
    for (red in redEdges) {
        graph[0][red[0]].add(red[1])
    }
    for (blue in blueEdges) {
        graph[1][blue[0]].add(blue[1])
    }
    val result = Array(2) { IntArray(n) { n*2 } }
    result[0][0] =0
    result[1][0] =0
    val queue: Queue<IntArray> = LinkedList<IntArray>()
    queue.offer(intArrayOf(0, 0))
    queue.offer(intArrayOf(0, 1))

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val cur = current.first()
        val col = current.last()
        for (next in graph[1 - col][cur]) {
            if (result[1 - col][next] == n*2) {
                result[1 - col][next] = 1 + result[col][cur]
                queue.offer(intArrayOf(next, 1 - col))
            }
        }
    }


    for (i in answer.indices) {
        val res = min(result[0][i], result[1][i])
        answer[i] = if (res == n*2) -1 else res
    }
    return answer
}
