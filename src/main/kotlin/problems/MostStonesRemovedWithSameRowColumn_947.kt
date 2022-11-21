package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(removeStones(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1))))
}

private fun removeStones(stones: Array<IntArray>): Int {
    var islands = 0
    val visited = BooleanArray(stones.size)
    for ((i, point) in stones.withIndex()) {
        if (!visited[i]) {
            islands++
            dfs(point, stones, visited)
        }
    }

    return stones.size - islands
}

private fun dfs(point: IntArray, stones: Array<IntArray>, visited: BooleanArray) {
    for (i in stones.indices) {
        if (!visited[i] && (point[0] == stones[i][0] || point[1] == stones[i][1])) {
            visited[i] = true
            dfs(stones[i], stones, visited)
        }
    }
}
