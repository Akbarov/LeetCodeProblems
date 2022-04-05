package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(
        isValidSudoku(
            arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
            )
        )
    )

}

private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val isValid3 = Array(9) { BooleanArray(9) }
    for (i in 0..8) {
        for (j in 0..8) {
            if (j % 3 == 0 && i % 3 == 0) {
                if (!isValid3x3(board, i, j)) {
                    return false
                }
            }
            val c = board[i][j]
            if (c == '.') continue
            val number = (c - '0') - 1
            if (number !in 0..8) {
                return false
            }
            if (isValid3[i][number]) {
                return false
            }
            isValid3[i][number] = true

            for (k in 1..8) {
                if (k == i) continue
                val char = board[k][j]
                if (char == '.') continue
                val num = (char - '0') - 1
                if (num == number) {
                    return false
                }
            }
        }
    }
    return true
}

private fun isValid3x3(board: Array<CharArray>, x: Int, y: Int): Boolean {
    val isValid3 = Array(3) { BooleanArray(3) }
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            val c = board[x + i][y + j]
            if (c == '.') continue
            val number = (c - '0') - 1
            if (number !in 0..8) {
                return false
            }
            if (isValid3[number / 3][number % 3]) {
                return false
            }
            isValid3[number / 3][number % 3] = true
        }
    }
    return true
}