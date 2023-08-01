package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun makeConnected(n: Int, connections: Array<IntArray>): Int {
    if (connections.size < n - 1) return -1
    val parent = IntArray(n) { i -> i }
    var count = n
    for (point in connections) {
        val p1 = findParent(parent, point.first())
        val p2 = findParent(parent, point.last())
        if (p1 != p2) {
            parent[p1] = p2
            count--
        }
    }
    return count - 1
}

private fun findParent(parent: IntArray, i: Int): Int {
    if (i == parent[i]) return i
    parent[i] = findParent(parent, parent[i])
    return parent[i]
}