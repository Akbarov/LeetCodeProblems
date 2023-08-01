package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
    val result = mutableListOf<Int>()
    val graph = Array(n) { mutableSetOf<Int>() }
    val notReachable = (0 until n).toMutableSet()
    for (e in edges) {
        graph[e[0]].add(e[1])
        notReachable.remove(e[1])
    }
    return notReachable.toList()

}