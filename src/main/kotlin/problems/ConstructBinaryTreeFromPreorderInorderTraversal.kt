package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val root = buildTree(intArrayOf(-1), intArrayOf(-1))
}

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val first = preorder.first()
    val root = TreeNode(first)

    val index = inorder.indexOf(first)

    val leftInorder = inorder.sliceArray(0 until index)
    val rightInorder = inorder.sliceArray(index + 1 until inorder.size)
    val leftPreorder = preorder.sliceArray(1..index)
    val rightPreorder = preorder.sliceArray(index + 1 until preorder.size)

    root.left = if (leftInorder.isNotEmpty()) buildTree(leftPreorder, leftInorder) else null
    root.right = if (rightInorder.isNotEmpty()) buildTree(rightPreorder, rightInorder) else null

    return root
}