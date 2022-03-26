package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val root = TreeNode(Int.MIN_VALUE)
    println(isValidBST2(root))

}

private val list = mutableListOf<Int>()
private fun isValidBST(root: TreeNode?): Boolean {
    inorder(root)
    for (i in 1..list.lastIndex) {
        if (list[i - 1] > list[i]) {
            return false
        }
    }
    return true

}

private fun inorder(root: TreeNode?) {
    if (root == null) return
    inorder(root.left)
    list.add(root.`val`)
    inorder(root.right)
}

private fun isValidBST2(root: TreeNode?, minRange: Long = Long.MIN_VALUE, maxRange: Long = Long.MAX_VALUE): Boolean {

    if (root == null) return true
    if (root.`val`<=minRange||root.`val`>maxRange) {
        return false
    }
    val left = isValidBST2(root.left, minRange, root.`val`-1L)
    val right = isValidBST2(root.right, root.`val`.toLong(), maxRange)
    return left && right

}
