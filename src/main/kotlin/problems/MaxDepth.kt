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
    maxDepth(root)
    println(length)
}

var length = 0
private fun maxDepth(root: TreeNode?): Int {
    depth(root, 0)
    return length
}

private fun depth(root: TreeNode?, count: Int) {
    if (root == null) {
        if (count > length) length = count
        return
    }
    depth(root.left, count + 1)
    depth(root.right, count + 1)
}
