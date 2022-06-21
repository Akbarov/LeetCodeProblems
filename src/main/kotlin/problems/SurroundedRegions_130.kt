package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    solve(
        arrayOf(
            charArrayOf('X','X','X','X'),
            charArrayOf('X','O','O','X'),
            charArrayOf('X','X','O','X'),
            charArrayOf('X','O','X','X'),
           
        )
    )
}

private fun solve(board: Array<CharArray>) {
    if (board.size < 2 || board[0].size < 2) return
    val m = board.size
    val n = board[0].size
    for (i in board.indices) {
        if (board[i][0] == 'O') {
            helper(board, i, 0)
        }
        if (board[i][n - 1] == 'O') {
            helper(board, i, n - 1)
        }
    }
    for (j in 0 until n) {
        if (board[0][j] == 'O') {
            helper(board, 0, j)
        }
        if (board[m - 1][j] == 'O') {
            helper(board, m - 1, j)
        }
    }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (board[i][j] == 'O') {
                board[i][j] = 'X'
            } else if (board[i][j] == '*') {
                board[i][j] = 'O'
            }
        }
    }

    for (a in board) {
        println(a.joinToString())
    }

}

private fun helper(board: Array<CharArray>, i: Int, j: Int) {
    if (i < 0 || i >= board.size || j < 0 || j >= board[0].size) return
    if (board[i][j] == 'X' || board[i][j] == '*') return
    if (board[i][j] == 'O') {
        board[i][j] = '*'
    }
    helper(board, i, j - 1)
    helper(board, i, j + 1)
    helper(board, i - 1, j)
    helper(board, i + 1, j)
}