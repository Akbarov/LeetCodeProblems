package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val root = TreeNode(1)
    root.left = TreeNode(0)
    println(sumNumbers(root))

}

private fun sumNumbers(root: TreeNode?, sum: Int = 0): Int {
    if (root == null) return 0
    if (root.left == null && root.right == null) return sum * 10 + root.`val`
    val left =  sumNumbers(root.left, (root.`val` + sum * 10))
    val right =  sumNumbers(root.right, (root.`val` + sum * 10))
    return left + right

}