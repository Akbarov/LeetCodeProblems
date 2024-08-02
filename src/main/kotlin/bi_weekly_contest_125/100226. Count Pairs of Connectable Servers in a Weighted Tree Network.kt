package bi_weekly_contest_125


fun main() {
    println(countPairsOfConnectableServers(arrayOf(
            intArrayOf(0, 6, 3),
            intArrayOf(6,5,3),
            intArrayOf(0,3,1),
            intArrayOf(3,2,7),
            intArrayOf(3,1,6),
            intArrayOf(3,4,2),
            ),3).joinToString())
}

private fun countPairsOfConnectableServers(edges: Array<IntArray>, signalSpeed: Int): IntArray {
    val n = edges.size + 1
    val graph = Array<MutableList<IntArray>>(n) { mutableListOf() }
    val leafs = IntArray(n)
    for (point in edges) {
        graph[point[0]].add(intArrayOf(point[1], point[2]))
        graph[point[1]].add(intArrayOf(point[0], point[2]))
        leafs[point[0]]++
        leafs[point[1]]++
    }
    val result = IntArray(n)
    for ((index, item) in leafs.withIndex()) {
        if (item == 1) {
            result[index] = 0
        } else {
            val list = mutableListOf<Int>()
            for (point in graph[index]) {
                val visited = BooleanArray(n)
                visited[index] = true
                val count = dfs(graph, point[0], signalSpeed, visited, point[1])
                list.add(count)
            }
            var current = 0
            for (i in list.indices) {
                for (j in i + 1 until list.size) {
                    current += list[i] * list[j]
                }
            }
            result[index] = current
        }
    }
    return result
}

private fun dfs(graph: Array<MutableList<IntArray>>, index: Int, speed: Int, visited: BooleanArray, current: Int): Int {
    if (visited[index]) return 0
    visited[index] = true
    var count = 0
    for (point in graph[index]) {
        count += dfs(graph, point[0], speed, visited, current + point[1])
    }
    return if (current % speed == 0) count + 1 else count
}