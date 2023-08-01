package problems


/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var result = 0
private fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (item in edges) {
        val a = item.first()
        val b = item.last()
        map.computeIfAbsent(a) { mutableListOf() }.add(b)
        map.computeIfAbsent(b) { mutableListOf() }.add(a)
    }
    map.keys.forEach {
        val visited = BooleanArray(vals.size)
        dfs(map, vals, visited, it, it)
    }
    return result / 2 + vals.size
}

private fun dfs(
    map: MutableMap<Int, MutableList<Int>>,
    vals: IntArray,
    visited: BooleanArray,
    start: Int,
    current: Int
) {
    if (start != current && vals[start] == vals[current]) {
        result++
    }
    visited[current] = true
    map[current]?.forEach {
        if (!visited[it] && vals[it] <= vals[start]) {
            dfs(map, vals, visited, start, it)
        }
    }
}