package algorithm_II.day_6_breadth_first_search

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var isConnected = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
    println(findCircleNum(isConnected))
    isConnected =
        arrayOf(intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(1, 0, 1, 1))
    println(findCircleNum(isConnected))

}

private fun findCircleNum(isConnected: Array<IntArray>): Int {

    var count = 0
    if (isConnected.size <= 1) return isConnected.size
    val isVisited = BooleanArray(isConnected.size)
    for (start in isConnected.indices) {
        if (!isVisited[start]) {
            bfs(isConnected, start, isVisited)
            count++
        }
    }
    return count
}

private fun bfs(isConnected: Array<IntArray>, start: Int, isVisited: BooleanArray) {
    if (isVisited[start]) return
    isVisited[start] = true
    for (i in 0..isVisited.lastIndex) {
        if (isConnected[start][i] == 1) {
            bfs(isConnected, i, isVisited)
        }
    }
}