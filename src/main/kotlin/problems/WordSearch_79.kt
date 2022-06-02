package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "SEE"
        )
    )
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCCED"
        )
    )
}

private fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in board.indices) {
        for (j in board[0].indices) {
            val ans = helper(board, word, i, j, 0)
            if (ans) return true
        }
    }
    return false
}

private fun helper(board: Array<CharArray>, word: String, i: Int, j: Int, count: Int): Boolean {
    if (i < 0 || j < 0 || i >= board.size || j >= board[0].size ||
        word.length <= count
    ) return false
    if (board[i][j] != word[count]) return false

    if (board[i][j] == word[count] && count == word.length - 1) {
        return true
    }
    board[i][j] = '*'
    val left = helper(board, word, i, j - 1, count + 1)
    val right = helper(board, word, i, j + 1, count + 1)
    val up = helper(board, word, i - 1, j, count + 1)
    val down = helper(board, word, i + 1, j, count + 1)
    if (left || right || up || down) return true
    board[i][j] = word[count]
    return false
}