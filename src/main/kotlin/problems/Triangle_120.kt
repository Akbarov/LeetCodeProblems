package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        minimumTotal(
            listOf(
                listOf(-1),
                listOf(2, 3),
                listOf(1, -1, -3),
            )
        )
    )
}

private fun minimumTotal(triangle: List<List<Int>>): Int {
    if (triangle.size == 1) return triangle.first().first()
    val result = mutableListOf<MutableList<Int>>()
    for (i in triangle) {
        result.add(i.toMutableList())
    }
    for (i in result.size - 2 downTo 0) {
        for (j in 0 until result[i].size) {
            result[i][j] += min(result[i + 1][j], result[i + 1][j + 1])
        }
    }
    return result.first().first()
}

