package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(tree2str(TreeNode(2)))
}

private fun tree2str(root: TreeNode?): String {
    if (root == null) return ""
    if (root.left == null && root.right == null) return "${root.`val`}"
    val left = tree2str(root.left)
    val right = tree2str(root.right)
    return if (right == "") "${root.`val`}($left)"
    else "${root.`val`}($left)($right)"
}
