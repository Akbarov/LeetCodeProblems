package algorithm_II.day_7_breadth_first_search

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

    if (root == null) return false
    return isSame(root, subRoot) || isSame(root.left, subRoot) || isSame(root.right, subRoot)

}

private fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) return true
    if (root == null || subRoot == null) return false
    return root.`val` == subRoot.`val` && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right)
}
