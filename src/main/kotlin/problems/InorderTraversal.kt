package problems

import algorithm_I.TreeNode
import com.sun.source.tree.Tree

fun main() {
    val root = TreeNode(1)
    val right = TreeNode(2)
    val childLeft = TreeNode(3)
    val left = TreeNode(4)
    right.left = childLeft
    root.right = right
    root.left = left
    inorderTraversal(root)
    println(list.joinToString())
}

private val list = mutableListOf<Int>()
private fun inorderTraversal(root: TreeNode?): List<Int> {

    addNumbers(root)
    return list
}

private fun addNumbers(root: TreeNode?) {
    if (root == null) {
        return
    }
    addNumbers(root.left)
    list.add(root.`val`)
    addNumbers(root.right)

}