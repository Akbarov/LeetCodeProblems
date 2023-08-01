package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestZigZag(TreeNode(1)))
}

private var longestStep = 0
private fun longestZigZag(root: TreeNode?): Int {
    if (root == null) return -1
    dfsZigZag(root, 0, true)
    dfsZigZag(root, 0, false)
    return longestStep
}

private fun dfsZigZag(root: TreeNode?, step: Int, isRight: Boolean) {
    if (root == null) return
    longestStep = Math.max(longestStep, step)
    if (isRight) {
        dfsZigZag(root.left, step + 1, false)
        dfsZigZag(root.left, 1, true)
    } else {
        dfsZigZag(root.right, step + 1, true)
        dfsZigZag(root.right, 1, false)
    }
}