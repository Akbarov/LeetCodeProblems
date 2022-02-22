package problems

import algorithm_I.TreeNode

fun main() {
    val root = TreeNode(4)
    val right = TreeNode(3)
    val left = TreeNode(1)
    root.left = left
    root.right = right
    println(hasPathSum(root,7))
}

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return if (root == null) false
    else if (root.`val` == targetSum && root.left == null && root.right == null) true
    else {
        hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
    }
}