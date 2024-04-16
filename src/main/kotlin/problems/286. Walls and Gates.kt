package problems

import java.util.LinkedList
import java.util.Queue

fun main() {

}

private fun wallsAndGates(rooms: Array<IntArray>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in rooms.indices) {
        for (j in rooms[i].indices) {
            if (rooms[i][j] == 0) {
                queue.add(Pair(i, j))
            }
        }
    }
    val m = rooms.size
    val n = rooms[0].size
    val edj = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    var step = 1
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val (i, j) = queue.poll()
            for (point in edj) {
                val nextRow = point.first() + i
                val nextCol = point.last() + j
                if (nextRow in 0 until m && nextCol in 0 until n && rooms[nextRow][nextCol] > step) {
                    rooms[nextRow][nextCol] = step
                    queue.add(Pair(nextRow, nextCol))
                }
            }
        }
        step++
    }

}
