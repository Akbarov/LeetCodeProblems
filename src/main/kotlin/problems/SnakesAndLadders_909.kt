package problems

import java.util.*


/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

fun snakesAndLadders(board: Array<IntArray>): Int {
    val n = board.size
    val queue: Queue<Int> = LinkedList()
    queue.offer(1)
    val visited = BooleanArray(n * n + 1)
    var move = 0
    while (!queue.isEmpty()) {
        for (size in queue.size downTo 1) {
            val num = queue.poll()
            if (visited[num]) continue
            visited[num] = true
            if (num == n * n) return move
            var i = 1
            while (i <= 6 && num + i <= n * n) {
                var next = num + i
                val value = getBoardValue(board, next)
                if (value > 0) next = value
                if (!visited[next]) queue.offer(next)
                i++
            }
        }
        move++
    }
    return -1
}

private fun getBoardValue(board: Array<IntArray>, num: Int): Int {
    val n = board.size
    val r = (num - 1) / n
    val x = n - 1 - r
    val y = if (r % 2 == 0) num - 1 - r * n else n + r * n - num
    return board[x][y]
}