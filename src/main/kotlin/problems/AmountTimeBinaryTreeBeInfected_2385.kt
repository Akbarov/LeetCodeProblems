package problems

import algorithm_I.TreeNode
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    amountOfTime(null, 3)
}

private var result = 0
private fun amountOfTime(root: TreeNode?, start: Int): Int {
    dfs(root, start)
    return result
}

private fun dfs(root: TreeNode?, start: Int): Int {
    if (root == null) return 0
    val left = dfs(root.left, start)
    val right = dfs(root.right, start)
    return if (root.`val` == start) {
        result = max(right, left)
        -1
    } else if (right >= 0 && left >= 0) {
        max(left, right) + 1
    } else {
        result = max(result, abs(left - right))
        min(left, right) - 1
    }
}
