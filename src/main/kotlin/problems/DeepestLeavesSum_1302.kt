package problems

import algorithm_I.TreeNode
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(3)
    val right = TreeNode(5)
    right.left = TreeNode(4)
    root.right = right
    println(deepestLeavesSum(root))
}

private fun deepestLeavesSum(root: TreeNode?): Int {
    val height = getHeight(root)
    return sumTheDeepestLeaves(root, height, 1)
}

private fun getHeight(root: TreeNode?): Int {
    if (root == null) return 0
    val left = getHeight(root.left)
    val right = getHeight(root.right)
    return max(left, right) + 1
}

private fun sumTheDeepestLeaves(root: TreeNode?, deepestHeight: Int, currentHeight: Int): Int {
    if (root == null) return 0
    if (deepestHeight == currentHeight)return root.`val`
    val left = sumTheDeepestLeaves(root.left, deepestHeight, currentHeight + 1)
    val right = sumTheDeepestLeaves(root.right, deepestHeight, currentHeight + 1)
    return left + right
}