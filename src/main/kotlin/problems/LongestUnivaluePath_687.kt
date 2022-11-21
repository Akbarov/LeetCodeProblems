package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var height = 0
private fun longestUnivaluePath(root: TreeNode?): Int {
    if (root == null) return height
    dfs(root)
    return height
}

private fun dfs(root: TreeNode?) {
    if (root == null) return
    val left = helper(root.left, root.`val`)
    val right = helper(root.right, root.`val`)
    if (left + right > height) {
        height = left + right
    }
    dfs(root.left)
    dfs(root.right)
}

private fun helper(root: TreeNode?, rootValue: Int): Int {
    if (root == null) return 0
    if (root.`val` != rootValue) return 0
    return helper(root.left, rootValue) + helper(root.right, rootValue) + 1
}
