package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestPath(intArrayOf(-1, 0, 0, 1, 1, 2), "abacbe"))
}

private var result = 0
private fun longestPath(parent: IntArray, s: String): Int {
    val map = mutableMapOf<Int, MutableList<Int>>()

    for (i in 1 until parent.size) {

        if (parent[i] in map) {
            map[parent[i]]?.add(i)
        } else {
            map[parent[i]] = mutableListOf(i)
        }
    }
    dfs(map, s, 0)
    return result
}

private fun dfs(map: MutableMap<Int, MutableList<Int>>, s: String, node: Int): Int {
    if (node !in map) return 1
    var firstMax = 0
    var secondMax = 0
    map[node]?.forEach {
        val longest = dfs(map, s, it)
        if (s[node] != s[it]) {
            if (longest > firstMax) {
                secondMax = firstMax
                firstMax = longest
            } else if (longest > secondMax) {
                secondMax = longest
            }
        }
    }
    result = Math.max(result, firstMax + secondMax + 1)
    return firstMax + 1
}