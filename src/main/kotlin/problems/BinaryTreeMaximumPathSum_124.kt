package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val head = TreeNode.generateTreeNode(listOf(1,2,3))
    println(maxPathSum(head))
}

private var result = Int.MIN_VALUE
private fun maxPathSum(root: TreeNode?): Int {
    if (root == null) return 0
    val t = helper(root)
    if (t > result) return t
    return result
}

private fun helper(root: TreeNode?): Int {
    if (root == null) return -10000
    val left = helper(root.left)
    val right = helper(root.right)
    if (result < root.`val`) result = root.`val`
    if (result < left) result = left
    if (result < right) result = right
    if (result < left + right + root.`val`) result = left + right + root.`val`
    if (left<0&&right<0) return root.`val`
    val sum = if (left > right) left + root.`val` else right + root.`val`
    return if (sum > 0) sum else 0
}