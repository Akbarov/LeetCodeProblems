package problems

import algorithm_I.TreeNode

fun main() {

}

private fun isSymmetric(root: TreeNode?): Boolean {

    return checker(root?.left, root?.right)
}

private fun checker(left: TreeNode?, right: TreeNode?): Boolean {
    return if (left == null && right == null) {
        true
    } else if (left == null || right == null) {
        false
    } else if (left.`val` != right.`val`)
        false
    else
        checker(left.left, right.right) && checker(left.right, right.left)
}