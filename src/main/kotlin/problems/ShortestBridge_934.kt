package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(shortestBridge(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
//    println(shortestBridge(arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 1))))
    println(
        shortestBridge(
            arrayOf(
                intArrayOf(1, 1, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 0, 0, 1),
                intArrayOf(1, 1, 1, 1, 1)
            )
        )
    )
}

private fun shortestBridge(grid: Array<IntArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var distance = 0
    loopOuter@ for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                makeFirstIsland(grid, i, j, queue)
                break@loopOuter
            }
        }
    }
    val coordinate = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val point = queue.poll()
            for (newPoint in coordinate) {
                val nextRow = point.first + newPoint.first()
                val nextCol = point.second + newPoint.last()
                if (nextRow >= 0 && nextRow < grid.size && nextCol >= 0 && nextCol < grid[0].size) {
                    if (grid[nextRow][nextCol] == 1) {
                        return distance
                    } else if (grid[nextRow][nextCol] == 0) {
                        queue.add(Pair(nextRow, nextCol))
                        grid[nextRow][nextCol] = -1
                    }
                }
            }
        }
        distance++
    }
    return distance
}

private fun makeFirstIsland(grid: Array<IntArray>, row: Int, col: Int, queue: Queue<Pair<Int, Int>>) {
    if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || grid[row][col] != 1) return
    grid[row][col] = 2
    queue.offer(Pair(row, col))
    makeFirstIsland(grid, row - 1, col, queue)
    makeFirstIsland(grid, row + 1, col, queue)
    makeFirstIsland(grid, row, col - 1, queue)
    makeFirstIsland(grid, row, col + 1, queue)
}