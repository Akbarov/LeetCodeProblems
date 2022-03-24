package problems

import algorithm_I.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    isBalanced(TreeNode(1))

}

private fun isBalanced(root: TreeNode?): Boolean {

    return abs(height(root?.left) - height(root?.right)) <= 1 && isBalanced(root?.left) && isBalanced(root?.right)

}

private fun height(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return 1 + max(height(root.left), height(root.right))
}
