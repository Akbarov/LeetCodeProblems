package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = solveNQueens(4)
    for (a in result) {
        for (s in a) {
            println(s)
        }
        println()
    }
}

private val col = mutableSetOf<Int>()
private val posDiag = mutableSetOf<Int>()
private val negDiag = mutableSetOf<Int>()
private val result = mutableListOf<List<String>>()

private fun solveNQueens(n: Int): List<List<String>> {
    val list = Array(n) { CharArray(n) { '.' } }
    dfs(list, 0, n)
    return result
}

private fun dfs(current: Array<CharArray>, row: Int, n: Int) {
    if (row == n) {
        val temp = mutableListOf<String>()
        for (a in current) {
            temp.add(a.joinToString(""))
        }
        result.add(temp)
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