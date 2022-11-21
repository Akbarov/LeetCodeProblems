package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        shortestPath(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 0, 0),
            ), 1
        )
    )

    println(
        shortestPath(
            arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 0, 0),
            ), 1
        )
    )
}


private fun shortestPath(grid: Array<IntArray>, k: Int): Int {

    val visited = Array(grid.size) { IntArray(grid[0].size) { -1 } }
    val queue: Queue<IntArray> = LinkedList()
    queue.add(intArrayOf(0, 0, 0, k))
    while (queue.isNotEmpty()) {
        val array = queue.poll()
        val x = array[0]
        val y = array[1]
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size) continue
        if (x == grid.size - 1 && y == grid[0].size - 1) {
            return array[2]
        }
        if (grid[x][y] == 1) {
            if (array[3] > 0) array[3]--
            else continue
        }
        if (visited[x][y] != -1 && visited[x][y] >= array[3]) continue
        visited[x][y] = array[3]
        queue.offer(intArrayOf(x - 1, y, array[2] + 1, array[3]))
        queue.offer(intArrayOf(x + 1, y, array[2] + 1, array[3]))
        queue.offer(intArrayOf(x, y - 1, array[2] + 1, array[3]))
        queue.offer(intArrayOf(x, y + 1, array[2] + 1, array[3]))
    }
    return -1

}
