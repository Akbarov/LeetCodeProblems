package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val root = TreeNode(4)
    root.left = TreeNode(3)
    root.right = TreeNode(5)
    root.right?.left = TreeNode(10)
    println(sumOfLeftLeaves(root))

}

private var sum = 0
private fun sumOfLeftLeaves(root: TreeNode?): Int {

    if (root == null) return 0
    if (root.left?.left == null && root.left?.right == null) {
        sum += (root.left?.`val` ?: 0)
    }
    sumOfLeftLeaves(root.left)
    sumOfLeftLeaves(root.right)
    return sum
}