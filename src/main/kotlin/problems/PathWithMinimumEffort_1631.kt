package problems

import java.util.*
import kotlin.math.abs
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var result = Int.MAX_VALUE
private val dir = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
private fun minimumEffortPath(heights: Array<IntArray>): Int {
    val efforts = Array(heights.size) { IntArray(heights[0].size) { Int.MAX_VALUE } }
    efforts[0][0] = 0
    val queue: Queue<IntArray> = LinkedList()
    queue.offer(intArrayOf(0, 0, 0))
    while (queue.isNotEmpty()) {
        val lastPoint = queue.poll()
        val eff = lastPoint[0]
        val i = lastPoint[1]
        val j = lastPoint[2]
        for (next in dir) {
            val row = i + next[0]
            val col = j + next[1]
            val newEff = max(eff, abs(efforts[row][col] - efforts[i][j]))
            if (row in heights.indices && col in heights[0].indices && efforts[row][col] > newEff) {
                efforts[row][col] = newEff
                queue.offer(intArrayOf(newEff, row, col))
            }
        }
    }
    return efforts.last().last()
}

