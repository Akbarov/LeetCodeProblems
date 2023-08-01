package problems

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxDistance(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 0), intArrayOf(1, 0, 1))))
    println(maxDistanceDP(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 0), intArrayOf(1, 0, 1))))
}

private fun maxDistance(grid: Array<IntArray>): Int {
    var result = -1
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val m = grid.size
    val n = grid[0].size
    val visited = Array(grid.size) { BooleanArray(grid[0].size) }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                queue.offer(Pair(i, j))
                visited[i][j] = true
            }
        }
    }
    val dirY = intArrayOf(-1, 0, 1, 0)
    val dirX = intArrayOf(0, -1, 0, 1)
    while (queue.isNotEmpty()) {
        val size = queue.size
        result++
        repeat(size) {
            val point = queue.poll()
            for (k in dirX.indices) {
                val row = dirY[k] + point.first
                val col = dirX[k] + point.second
                if (row in 0 until m && col in 0 until n && !visited[row][col]) {
                    queue.offer(Pair(row, col))
                    visited[row][col] = true
                }
            }
        }
    }
    return if (result <= 1) -1 else result
}

private fun maxDistanceDP(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val disMax = m + n + 1
    var ans = Int.MIN_VALUE

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0
            } else {
                grid[i][j] = disMax
                grid[i][j] = min(
                    grid[i][j],
                    min((if (i > 0) grid[i - 1][j] + 1 else disMax), (if (j > 0) grid[i][j - 1] + 1 else disMax))
                )
            }
        }
    }
    for (i in m - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            grid[i][j] = min(
                grid[i][j],
                min(
                    (if (i < m - 1) grid[i + 1][j] + 1 else disMax),
                    (if (j < n - 1) grid[i][j + 1] + 1 else disMax)
                )
            )
            ans = max(ans, grid[i][j])
        }
    }

    return if(ans==0||ans==Int.MIN_VALUE) -1 else ans
}