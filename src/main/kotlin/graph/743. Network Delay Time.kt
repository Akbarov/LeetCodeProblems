package graph


fun main() {

}

private fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val graph = createGraph(times, n)
    val totalTime = IntArray(n)
    totalTime[k - 1] = 0
    useDijkstra(graph, k - 1, totalTime)
    val result = totalTime.maxOrNull() ?: Int.MAX_VALUE
    return if (result == Int.MAX_VALUE) -1 else result
}


private fun useDijkstra(graph: Array<MutableList<Edge>>, start: Int, totaltime: IntArray) {
    for (edge in graph[start]) {
        if (totaltime[start] + edge.initial < totaltime[edge.target]) {
            totaltime[edge.target] = totaltime[start] + edge.initial
            useDijkstra(graph, edge.target, totaltime)
        }
    }
}

private fun createGraph(times: Array<IntArray>, n: Int): Array<MutableList<Edge>> {
    val result = Array(n) { mutableListOf<Edge>() }
    for (point in times) {
        result[point[0] - 1].add(Edge(point[1] - 1, point[2]))
    }
    return result
}

private data class Edge(val target: Int, val initial: Int)