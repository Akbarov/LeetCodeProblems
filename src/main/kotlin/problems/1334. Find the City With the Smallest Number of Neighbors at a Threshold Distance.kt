package problems

import java.util.*


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        findTheCity(
            4,
            arrayOf(intArrayOf(0, 1, 3), intArrayOf(1, 2, 1), intArrayOf(1, 3, 4), intArrayOf(2, 3, 1)),
            4
        )
    )
}

private fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
    val INF = 1e9.toInt() + 7
    val adj = Array(n) { mutableListOf<IntArray>() }
    val dist = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        Arrays.fill(dist[i], INF)
        dist[i][i] = 0
    }
    for (i in 0 until n) {
        adj[i] = ArrayList()
    }
    for (e in edges) {
        val u = e[0]
        val v = e[1]
        val d = e[2]
        adj[u].add(intArrayOf(v, d))
        adj[v].add(intArrayOf(u, d))
         dist[u][v] = d
         dist[v][u] = d
    }

    floyd(n, adj, dist);

    var minCity = -1
    var minCount = n
    for (i in 0 until n) {
        var curCount = 0
        for (j in 0 until n) {
            if (i == j) {
                continue
            }
            if (dist[i][j] <= distanceThreshold) {
                curCount++
            }
        }
        if (curCount <= minCount) {
            minCount = curCount
            minCity = i
        }
    }
    return minCity
}

fun floyd(n: Int, adj: Array<MutableList<IntArray>>, dist: Array<IntArray>) {
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                dist[i][j] = dist[i][j].coerceAtMost(dist[i][k] + dist[k][j])
            }
        }
    }
}
