package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {


      println(hasValidPath(arrayOf(charArrayOf('(', ')'), charArrayOf('(', ')'))))
//      println(hasValidPath(arrayOf(charArrayOf(')', ')'), charArrayOf('(', '('))))
//    println(
//        hasValidPath(
//            arrayOf(
//                charArrayOf('(', '(', '('),
//                charArrayOf(')', '(', ')'),
//                charArrayOf('(', '(', ')'),
//                charArrayOf('(', '(', ')'),
//            )
//        )
//    )
}


private fun hasValidPath(grid: Array<CharArray>): Boolean {

    return helper(grid, 0, 0, Stack())

}

private fun helper(grid: Array<CharArray>, i: Int = 0, j: Int = 0, stack: Stack<Char>): Boolean {
    val c = grid[i][j]
    if (c == '(') {
        stack.push(c)
    } else {
        if (stack.isEmpty()) {
            return false
        }
        val t = stack.pop()
        if (t != '(') {
            return false
        }
        if (i == grid.size - 1 && j == grid[0].size - 1) {
            println(stack.size)
            return stack.isEmpty()
        }
    }
    val right = if (j < grid[0].lastIndex) helper(grid, i, j + 1, stack.clone() as Stack<Char>) else false
    val down = if (i < grid.lastIndex) helper(grid, i + 1, j, stack.clone() as Stack<Char>) else false
    return right || down
}