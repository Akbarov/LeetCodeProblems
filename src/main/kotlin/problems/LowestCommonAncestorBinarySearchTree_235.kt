package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) return root
    return if ((root.`val` - p.`val`) * (root.`val` - q.`val`) < 1) root
    else lowestCommonAncestor(if (p.`val` < root.`val`) root.left else root.right, p, q)
}