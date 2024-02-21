package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(knightDialer(1))
    println(knightDialer(2))
}

private val mod = 1_000_000_007
private fun knightDialer(n: Int): Int {
    val map = Array(10) { mutableListOf<Int>() }
    map[0] = mutableListOf(4, 6)
    map[1] = mutableListOf(6, 8)
    map[2] = mutableListOf(7, 9)
    map[3] = mutableListOf(4, 8)
    map[4] = mutableListOf(0, 3, 9)
    map[5] = mutableListOf()
    map[6] = mutableListOf(0, 1, 7)
    map[7] = mutableListOf(2, 6)
    map[8] = mutableListOf(1, 3)
    map[9] = mutableListOf(2, 4)
    var result = 0

    val memo = Array(n) { IntArray(10) { -1 } }
    for (i in 0..9) {
        result = (result + dfs(map, memo, i, n - 1)) % mod
    }
    return result
}

private fun dfs(map: Array<MutableList<Int>>, memo: Array<IntArray>, index: Int, n: Int): Int {
    if (n == 0) return 1
    if (memo[n][index] != -1) return memo[n][index]
    var current = 0
    for (i in map[index]) {
        current = (current + dfs(map, memo, i, n-1)) % mod
    }
    memo[n][index] = current
    return current
}