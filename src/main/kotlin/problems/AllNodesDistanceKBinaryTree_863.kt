package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private val map = mutableMapOf<TreeNode, Int>()
private fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    find(root, target)
    dfs(root, target, k, map[root] ?: 0, result)
    return result
}

private fun find(root: TreeNode?, target: TreeNode?): Int {
    if (root == null) return -1
    if (root == target) {
        map[root] = 0
        return 0
    }
    find(root.left, target).apply {
        if (this >= 0) {
            map[root] = this + 1
            return this + 1
        }
    }
    find(root.right, target).apply {
        if (this >= 0) {
            map[root] = this + 1
            return this + 1
        }
    }
    return -1

}

private fun dfs(root: TreeNode?, target: TreeNode?, k: Int, length: Int, result: MutableList<Int>) {
    if (root == null) return
    var newLength = length
    map[root]?.apply {
        newLength = this
    }
    if (newLength == k) result.add(root.`val`)
    dfs(root.left, target, k, newLength + 1, result)
    dfs(root.right, target, k, newLength + 1, result)
}