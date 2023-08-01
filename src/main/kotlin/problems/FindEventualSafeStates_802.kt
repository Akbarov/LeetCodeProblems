package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val resultList = mutableListOf<Int>()
    val visited = BooleanArray(graph.size)
    val safeSet = mutableSetOf<Int>()
    for (index in graph.indices) {
        if (graph[index].isEmpty() || index in safeSet) {
            resultList.add(index)
        } else {
            if (isSafeNode(graph, visited, safeSet, index)) resultList.add(index)
        }
    }
    return resultList
}

private fun isSafeNode(graph: Array<IntArray>, visited: BooleanArray, safeSet: MutableSet<Int>, index: Int): Boolean {
    if (graph[index].isEmpty()||index in safeSet) return true
    if (visited[index]) return false
    visited[index] = true
    var isSafe = true
    for (i in graph[index]) {
        isSafe = isSafe && isSafeNode(graph, visited, safeSet, i)
    }
    if (isSafe) safeSet.add(index)
    return isSafe
}