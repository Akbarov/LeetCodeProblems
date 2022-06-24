package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

var seen = false
private fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    val visited = BooleanArray(n)
    for (i in 0 until n) {
        graph[i] = mutableSetOf()
    }
    for (ed in edges) {
        graph[ed[0]]?.add(ed[1])
        graph[ed[1]]?.add(ed[0])
    }
    if (graph[source]?.contains(destination) == true) return true

    dfs(graph, source, destination, visited)
    return seen

}

private fun dfs(graph: MutableMap<Int, MutableSet<Int>>, source: Int, destination: Int, visited: BooleanArray) {
    if (!visited[source] && !seen) {

        if (source == destination) {
            seen = true
            return
        }
        visited[source] = true
        val set = graph[source] ?: mutableSetOf()
        for (item in set) {
            dfs(graph, source, item, visited)
        }
    }
}