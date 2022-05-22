package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numSquares(13))
    println(numSquares(12))
    println(numSquares2(53))
}

private var result = Int.MAX_VALUE
private fun numSquares(n: Int): Int {
    result = Int.MAX_VALUE

    dfs(n.toLong(), 0, 0)
    return result
}

private fun dfs(n: Long, sum: Long, count: Int) {
    if (n < sum) return
    if (n == sum) {
        if (count < result) result = count
        return
    }
    var i = 1
    while (i * i <= n) {
        dfs(n, sum + i * i, count + 1)
        i++
    }
}

private fun numSquares2(n: Int): Int {
    val array = IntArray(n + 1) { n }
    if (n < 0) return 0
    array[0] = 0
    for (i in 1..n) {
        for (j in 1..n) {
            if (j * j > i) break
            array[i] = min(array[i],array[i-j*j]+1)
        }
    }
    return array[n]
}