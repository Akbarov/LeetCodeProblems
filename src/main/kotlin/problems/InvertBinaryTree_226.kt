package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val root = TreeNode(2)
    root.left = TreeNode(3)
    root.right = TreeNode(4)
    val temp = invertTree(root)
    println(temp?.`val`)
    println(temp?.left?.`val`)
    println(temp?.right?.`val`)

}

private fun invertTree(root: TreeNode?): TreeNode? {

    if (root == null) return null
    val left = invertTree(root.left)
    val right = invertTree(root.right)
    root.right = left
    root.left = right
    return root

}

