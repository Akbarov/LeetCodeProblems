package graph


fun main() {
    findRedundantConnection(arrayOf(intArrayOf(1, 2)))
}

private fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val n = edges.size
    val graph = Array(edges.size + 1) { mutableSetOf<Int>() }
    for (point in edges) {
        graph[point[0]].add(point[1])
        graph[point[1]].add(point[0])
        if (hasCycle(graph, point[0], point[1], BooleanArray(n + 1))) return point
    }
    return intArrayOf()
}

private fun hasCycle(graph: Array<MutableSet<Int>>, start: Int, parent: Int, visited: BooleanArray): Boolean {
    visited[start] = true
    for (item in graph[start]) {
        if (!visited[item]) {
            if (hasCycle(graph, item, start, visited)) return true
        } else if (item != parent) return true
    }
    return false
}