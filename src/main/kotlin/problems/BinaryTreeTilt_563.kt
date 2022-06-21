package problems

import algorithm_I.TreeNode
import kotlin.math.abs

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var result = 0
private fun findTilt(root: TreeNode?): Int {
    result = 0
    preOrder(root)
    return result
}

private fun preOrder(root: TreeNode?): Int {
    if (root == null) return 0
    val left = findTilt(root.left)
    val right = findTilt(root.right)
    result = abs(left - right)
    return left + right + root.`val`
}