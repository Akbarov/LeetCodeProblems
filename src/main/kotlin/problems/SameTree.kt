package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (q == null && p == null) return true
    if (q == null || p == null || q.`val` != p.`val`) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}