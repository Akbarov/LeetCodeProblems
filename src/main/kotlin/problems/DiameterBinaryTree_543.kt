package problems

import algorithm_I.TreeNode
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var leng = 0
private fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0
    helper(root)
    return leng
}

private fun helper(root: TreeNode?): Int {
    if (root == null) return 0
    val left = helper(root.left)
    val right = helper(root.right)
    leng = max(left + right, leng)
    return max(left, right) + 1
}
