package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = totalNQueens(4)
    println(result)
}

private val col = mutableSetOf<Int>()
private val posDiag = mutableSetOf<Int>()
private val negDiag = mutableSetOf<Int>()
private var result = 0

private fun totalNQueens(n: Int): Int {
    val list = Array(n) { CharArray(n) { '.' } }
    result = 0
    dfs(list, 0, n)
    return result
}

private fun dfs(current: Array<CharArray>, row: Int, n: Int) {
    if (row == n) {
        result++
        return
    }
    for (c in 0 until n) {
        if (c in col || (row + c) in posDiag || (row - c) in negDiag) continue
        current[row][c] = 'Q'
        col.add(c)
        posDiag.add(row + c)
        negDiag.add(row - c)

        dfs(current, row + 1, n)

        current[row][c] = '.'
        col.remove(c)
        posDiag.remove(row + c)
        negDiag.remove(row - c)
    }
}