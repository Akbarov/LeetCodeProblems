package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        canFinish(
            5, arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 4),
                intArrayOf(3, 1),
                intArrayOf(3, 2),
            )
        )
    )
}

private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val dp = Array(numCourses) { mutableListOf<Int>() }
    for (p in prerequisites) {
        dp[p[1]].add(p[0])
    }
    val visited = BooleanArray(numCourses)
    val done = BooleanArray(numCourses)
    for (i in 0 until numCourses) {
        if (!done[i] && !dfs(visited, dp, i, done)) return false
    }
    return true
}

private fun dfs(visited: BooleanArray, dp: Array<MutableList<Int>>, index: Int, done: BooleanArray): Boolean {
    if (visited[index]) return false
    if (done[index]) return true
    visited[index] = true
    done[index] = true
    for (item in dp[index]) {
        if (!dfs(visited, dp, item,done)) {
            return false
        }
    }
    visited[index] = false
    return true
}