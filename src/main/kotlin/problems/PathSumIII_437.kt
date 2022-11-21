package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val root = TreeNode(10)
    val right = TreeNode(-3)
    val left = TreeNode(-2)
    val leaf = TreeNode(11)
    right.right = leaf
    root.right = right
    root.left = left
    println(pathSum(root, 8))
}

private var count = 0
private fun pathSum(root: TreeNode?, sum: Int): Int {
    recursive(root, sum)
    return count
}

private fun recursive(root: TreeNode?, sum: Int) {
    helper(root, sum.toLong())
    if (root != null) {
        recursive(root.left, sum)
        recursive(root.right, sum)
    }
}

private fun helper(root: TreeNode?, sum: Long) {
    if (root == null) return
    if (sum == root.`val`.toLong()) count++
    helper(root.left, sum - root.`val`)
    helper(root.right, sum - root.`val`)
}