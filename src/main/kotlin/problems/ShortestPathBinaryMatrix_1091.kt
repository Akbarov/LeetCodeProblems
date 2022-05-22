package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
            )
        )
    )
    println(
        shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(1, 0)
            )
        )
    )
}

private fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return -1
    if (grid.first().first() == 1 || grid.last().last() == 1) return -1
    val n = grid.size
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(n) { BooleanArray(n) }
    queue.offer(Pair(0, 0))
    visited[0][0] = true
    var ans = 0
    while (queue.isNotEmpty()) {
        var size = queue.size
        ans++
        while (size-- > 0) {
            val (i, j) = queue.poll()
            if (i == n - 1 && j == n - 1) return ans
            for (k in i - 1..i + 1) {
                for (l in j - 1..j + 1) {
                    if (k >= 0 && l >= 0 && k < n && l < n && !visited[k][l] && grid[k][l] == 0) {
                        queue.offer(Pair(k, l))
                        visited[k][l] = true
                    }
                }
            }
        }
    }
    return -1
}
