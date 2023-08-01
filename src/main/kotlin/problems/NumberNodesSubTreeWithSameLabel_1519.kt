package problems

/**
Creator: Zohidjon Akbarov
 */

fun main() {
    println(countSubTrees(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)), "aba").joinToString())
}

private fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (point in edges) {
        if (point[0] in map) {
            map[point[0]]?.add(point[1])
        } else {
            map[point[0]] = mutableListOf(point[1])
        }
        if (point[1] in map) {
            map[point[1]]?.add(point[0])
        } else {
            map[point[1]] = mutableListOf(point[0])
        }
    }
    val visited = BooleanArray(n)
    val result = IntArray(n)
    dfs(map, labels, 0, result, visited)
    return result
}

private fun dfs(
    map: MutableMap<Int, MutableList<Int>>,
    labels: String,
    i: Int,
    result: IntArray,
    visited: BooleanArray
): IntArray {
    val chars = IntArray(26)
    if (visited[i]) return chars
    visited[i] = true
    map[i]?.forEach {
        if (!visited[it]) {
            val temp = dfs(map, labels, it, result, visited)
            for (j in 0 until 26) {
                chars[j] += temp[j]
            }
        }
    }
    chars[labels[i] - 'a']++
    result[i] = chars[labels[i] - 'a']
    return chars
}