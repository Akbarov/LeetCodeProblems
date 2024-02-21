package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minCostConnectPoints(points: Array<IntArray>): Int {
    val len: Int = points.size
    // array that keep track of the shortest distance from mst to each node
    // array that keep track of the shortest distance from mst to each node
    val disArr = IntArray(len)
    for (i in 1 until len) {
        disArr[i] = Int.MAX_VALUE
    }
    // visited[node] == true if node in mst
    // visited[node] == true if node in mst
    val visited = BooleanArray(len)
    visited[0] = true

    var numEdge = 0
    // current node, used to update the disArr
    // current node, used to update the disArr
    var cur = 0
    // result
    // result
    var res = 0

    while (numEdge++ < len - 1) {
        var minEdge = Int.MAX_VALUE
        var next = -1
        for (i in 0 until len) {
            // if the node i is not in mst
            if (!visited[i]) {
                // find the distance between cur and i
                val dis = Math.abs(points[cur][0] - points[i][0]) + Math.abs(points[cur][1] - points[i][1])
                // update distance array
                disArr[i] = Math.min(dis, disArr[i])
                // find the shortest edge
                if (disArr[i] < minEdge) {
                    minEdge = disArr[i]
                    next = i
                }
            }
        }
        cur = next
        visited[cur] = true
        res += minEdge
    }

    return res
}