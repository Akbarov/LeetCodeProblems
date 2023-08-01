package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        minTime(
            7, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 4),
                intArrayOf(1, 5),
                intArrayOf(2, 3),
                intArrayOf(2, 6),
            ), listOf(false, false, true, false, true, true, false)
        )
    )
}

private var result = 0
private fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (point in edges) {
        if (point[0] in map) {
            map[point[0]]?.add(point[1])
        } else {
            map[point[0]] = mutableListOf(point[1])
        }
        if (point[1] in map) {
            map[point[1]]?.add(point[0])
        } else {
            map[point[1]] = mutableListOf(point[0])
        }
    }
    val visited = BooleanArray(n)
    return helper(map, hasApple, visited, 0)
}

private fun helper(
    edges: MutableMap<Int, MutableList<Int>>,
    hasApple: List<Boolean>,
    visited: BooleanArray,
    i: Int
): Int {
    if (i < 0 || i >= visited.size || visited[i]) return 0
    visited[i] = true
    var count = 0
    edges[i]?.forEach {
        count += helper(edges, hasApple, visited, it)
    }
    if (count > 0) return count + 2
    if (hasApple[i]) return 2
    return 0
}