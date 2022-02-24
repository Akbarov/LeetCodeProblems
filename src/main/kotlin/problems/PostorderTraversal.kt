package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private val list = mutableListOf<Int>()
private fun postorderTraversal(root: TreeNode?): List<Int> {
    addList(root)
    return list
}

private fun addList(root: TreeNode?) {
    if (root == null) return
    addList(root.left)
    addList(root.right)
    list.add(root.`val`)
}