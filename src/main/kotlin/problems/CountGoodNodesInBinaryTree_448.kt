package problems

import algorithm_I.TreeNode
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var totalCount = 0
private fun goodNodes(root: TreeNode?): Int {
    if (root == null) return totalCount
    helper(root, valMax = root.`val`)
    return totalCount
}

private fun helper(root: TreeNode?, valMax: Int) {
    if (root == null) return
    if (root.`val` >= valMax) totalCount++
    helper(root.left, max(root.`val`, valMax))
    helper(root.right, max(root.`val`, valMax))
}