package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    pruneTree(TreeNode(0))
}

private fun pruneTree(root: TreeNode?): TreeNode? {
    helper(root)
    return root
}

private fun helper(root: TreeNode?): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null)
        return root.`val` == 1
    val left = helper(root.left)
    val right = helper(root.right)
    if (!left) root.left = null
    if (!right) root.right = null
    return root.`val` == 1 || left || right

}