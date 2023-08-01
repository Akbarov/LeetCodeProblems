package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(allPathsSourceTarget(arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf())))
}

private val result = mutableListOf<MutableList<Int>>()
private fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    val visited = BooleanArray(graph.size)
    visited[0] = true
    for (item in graph[0]) {
        val list = mutableListOf<Int>(0)
        list.add(item)
        helper(graph, visited, list, item)
    }
    return result
}

private fun helper(graph: Array<IntArray>, visited: BooleanArray, list: MutableList<Int>, index: Int) {
    if (index == graph.size - 1) {
        val t = mutableListOf<Int>()
        t.addAll(list)
        result.add(t)
        return
    }
    for (item in graph[index]) {
        list.add(item)
        helper(graph, visited, list, item)
        list.removeAt(list.size - 1)
    }
}