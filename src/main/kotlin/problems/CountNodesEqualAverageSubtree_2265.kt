package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var total = 0
private fun averageOfSubtree(root: TreeNode?): Int {
    dfs(root)

    return total
}

private fun dfs(root: TreeNode?): IntArray {
    if (root == null) {
        return intArrayOf(0, 0)
    }
    val left = dfs(root.left)
    val right = dfs(root.right)
    val sum = left[0] + right[0] + root.`val`
    val count = left[1] + right[1] + 1
    if (sum / count == root.`val`) {
        total++
    }
    return intArrayOf(sum,count)
}
