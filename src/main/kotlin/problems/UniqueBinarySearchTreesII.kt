package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = generateTrees(3)
    for (item in result) {
        println(item?.`val`)
    }
}

private fun generateTrees(n: Int): List<TreeNode?> {
    if (n == 0) return emptyList()
    return helper(1, n)
}

private fun helper(start: Int, end: Int): List<TreeNode?> {
    val list = mutableListOf<TreeNode?>()
    if (start > end) {
        list.add(null)
        return list
    }
    for (i in start..end) {
        val left = helper(start, i - 1)
        val right = helper(i + 1, end)
        for (l in left) {
            for (r in right) {
                val root = TreeNode(i)
                root.left = l
                root.right = r
                list.add(root)
            }
        }
    }
    return list
}