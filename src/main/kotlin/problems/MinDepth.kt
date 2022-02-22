package problems

import algorithm_I.TreeNode
import kotlin.math.min

fun main() {

}

var minLength = Int.MAX_VALUE
private fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    helper(root, 0)
    return minLength
}

private fun helper(root: TreeNode?, count: Int) {
    if (root == null) return
    if (root.left == null && root.right == null) {
        if (minLength > count) minLength = count
        return
    }
    helper(root.left, count + 1)
    helper(root.right, count + 1)
}