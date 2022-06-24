package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var result = 0
 private fun minDiffInBST(root: TreeNode?): Int {
    helper(root)
    return result
}

 private fun helper(root: TreeNode?) {
    if (root == null) return
    if (root.left != null) {
        result = Math.min(result, (root.`val` - (root.left?.`val`!!) ))
    }
    if (root.right != null) {
        result = Math.min(result, ((root.right?.`val` ?: 0) - root.`val`))
    }
    helper(root.left)
    helper(root.right)
}