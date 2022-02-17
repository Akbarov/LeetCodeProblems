package algorithm_I.day_8_bread_first_search

import algorithm_I.TreeNode

fun main() {

}

private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    return if (root1 == null && root2 == null) null
    else if (root1 == null) {
        root2
    } else if (root2 == null) {
        root1
    } else {
        root1.`val` += root2.`val`
        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)
        root1
    }
}

