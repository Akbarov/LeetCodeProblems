package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private val list = mutableListOf<TreeNode>()
private fun flatten(root: TreeNode?) {
    if (root?.left == null && root?.right == null) return

    preOrder(root)
    for (i in 0 until list.lastIndex) {
        val temp = list[i]
        temp.left = null
        temp.right = list[i + 1]
    }

}

private fun preOrder(root: TreeNode?) {
    if (root == null) return
    list.add(root)
    preOrder(root.left)
    preOrder(root.right)
}