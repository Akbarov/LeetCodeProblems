package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        nearestExit(
            arrayOf(
                charArrayOf('+', '+', '.', '+'),
                charArrayOf('.', '.', '.', '+'),
                charArrayOf('+', '+', '+', '+'),
            ), intArrayOf(1, 2)
        )
    )

}

private var result = 10_000
private fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    if (maze.isEmpty() || maze.size <= entrance[0] || maze[0].size <= entrance[1]) return -1
    val queue: Queue<IntArray> = LinkedList()
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    queue.offer(intArrayOf(entrance[0], entrance[1], 0))
    maze[entrance[0]][entrance[1]] = '+'
    while (queue.isNotEmpty()) {
        val array = queue.poll()
        val curRow = array[0]
        val curColumn = array[1]
        val distance = array[2]
        for (d in dirs) {
            val row = curRow + d[0]
            val column = curColumn + d[1]
            if (row >= 0 && row < maze.size && column >= 0 && column < maze[0].size && maze[row][column] == '.') {
                if (row == 0 || column == 0 || row == maze.size - 1 || column == maze[0].size - 1) {
                    return distance + 1
                }
                maze[row][column] = '+'
                queue.offer(intArrayOf(row, column, distance + 1))
            }
        }
    }
    return -1
}

