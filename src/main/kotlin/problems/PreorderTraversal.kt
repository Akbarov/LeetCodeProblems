package problems

import algorithm_I.TreeNode

fun main() {
    val root = TreeNode(1)
    val right = TreeNode(2)
    val childLeft = TreeNode(3)
    val left = TreeNode(4)
    right.left = childLeft
    root.right = right
    root.left = left
    preorderTraversal(root)
    println(list.joinToString())
}

private val list = mutableListOf<Int>()
private fun preorderTraversal(root: TreeNode?): List<Int> {

    addNumbers(root)
    return list
}

private fun addNumbers(root: TreeNode?) {
    if (root == null) {
        return
    }
    list.add(root.`val`)
    addNumbers(root.left)
    addNumbers(root.right)

}