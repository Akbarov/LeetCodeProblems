package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val root = buildTree(intArrayOf(-1), intArrayOf(-1))
}

private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    val last = postorder.last()
    val root = TreeNode(last)

    val index = inorder.indexOf(last)

    val leftInorder = inorder.sliceArray(0 until index)
    val rightInorder = inorder.sliceArray(index + 1..inorder.size)
    val leftPostorder = postorder.sliceArray(0 until index)
    val rightPostorder = postorder.sliceArray(index until postorder.size)

    root.left = if (leftInorder.isNotEmpty()) buildTree(leftInorder, leftPostorder) else null
    root.right = if (rightInorder.isNotEmpty()) buildTree(rightInorder, rightPostorder) else null

    return root
}