package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minReorder(2, arrayOf(intArrayOf(0,1))))
}

private fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val dp = Array<MutableList<Int>>(n) { mutableListOf() }
    val reverse = Array<MutableList<Int>>(n) { mutableListOf() }
    for (con in connections) {
        dp[con[0]].add(con[1])
        reverse[con[1]].add(con[0])
    }
    var count = 0
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(n)
    queue.offer(0)
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        visited[cur] = true
        for (item in dp[cur]) {
            if (!visited[item]) {
                count++
                queue.offer(item)
            }
        }
        for (item in reverse[cur]) {
            if (!visited[item]) {
                queue.offer(item)
            }
        }
    }
    return count
}