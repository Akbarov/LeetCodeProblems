package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun findRedundantConnection(edges: Array<IntArray>): IntArray {

    val graph = mutableMapOf<Int, MutableList<Int>>()
    for (point in edges) {
        if (graph[point[0]] == null) {
            graph[point[0]] = mutableListOf()
        }
        graph[point[0]]?.add(point[1])

        if (graph[point[1]] == null) {
            graph[point[1]] = mutableListOf()
        }
        graph[point[1]]?.add(point[0])
    }
    return intArrayOf()
}