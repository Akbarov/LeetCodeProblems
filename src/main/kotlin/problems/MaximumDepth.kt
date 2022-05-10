package problems

import algorithm_I.TreeNode
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

// top-down approach
private var answer = 0
private fun maxDepth(root: TreeNode?, depth: Int = 1) {
    if (root == null) return
    if (root.left == null && root.right == null) {
        answer = max(answer, depth)
    }
    maxDepth(root.left, depth + 1)
    maxDepth(root.right, depth + 1)
}

//bottom-up approach
private fun maxDepthBottomUp(root: TreeNode?): Int {
    if (root == null) return 0
    val left = maxDepthBottomUp(root.left)
    val right = maxDepthBottomUp(root.right)
    return max(left, right) + 1
}
