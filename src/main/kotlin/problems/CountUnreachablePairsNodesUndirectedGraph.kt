package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countPairs(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))))
}

private fun countPairs(n: Int, edges: Array<IntArray>): Long {
    val set = DisjointSetUnion(n)
    for (ed in edges) {
        set.union(ed[0], ed[1])
    }
    var count = 0L
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (!set.areConnected(i, j)) {
                count++
            }
        }
    }
    return count
}

internal class DisjointSetUnion(private val N: Int) {
    private val parent: IntArray = IntArray(N)

    init {
        for (i in 0 until N) {
            parent[i] = i
        }
    }

    fun areConnected(u: Int, v: Int): Boolean {
        return find(u) == find(v)
    }

    fun union(u: Int, v: Int) {
        if (u != v) {
            val a = find(u)
            val b = find(v)
            parent[a] = b
        }
    }

    private fun find(u: Int): Int {
        var x = u
        while (x != parent[x]) {
            x = parent[x]
        }
        parent[u] = x
        return x
    }
}