package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = pacificAtlantic(
        arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4),
        )
    )
    result.forEach {
        println(it.joinToString())
    }
}

private val result = mutableListOf<List<Int>>()
private lateinit var atlantic: Array<BooleanArray>
private lateinit var pacific: Array<BooleanArray>
private var m = 0
private var n = 0
private fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    m = heights.size
    n = heights[0].size
    atlantic = Array(m) { BooleanArray(n) }
    pacific = Array(m) { BooleanArray(n) }
    if (heights.isEmpty()) return emptyList()
    for (i in heights.indices) {
        helper(heights, pacific, i, 0)
        helper(heights, atlantic, i, n - 1)
    }
    for (j in 0 until n) {
        helper(heights, pacific, 0, j)
        helper(heights, atlantic, m - 1, j)
    }
    return result
}

private fun helper(heights: Array<IntArray>, visited: Array<BooleanArray>, i: Int, j: Int) {
    if (visited[i][j]) return
    visited[i][j] = true
    if (atlantic[i][j] && pacific[i][j]) result.add(listOf(i, j))
    if (i + 1 < m && heights[i + 1][j] >= heights[i][j]) helper(heights, visited, i + 1, j)
    if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) helper(heights, visited, i - 1, j)
    if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) helper(heights, visited, i, j - 1)
    if (j + 1 < n && heights[i][j + 1] >= heights[i][j]) helper(heights, visited, i, j + 1)
}