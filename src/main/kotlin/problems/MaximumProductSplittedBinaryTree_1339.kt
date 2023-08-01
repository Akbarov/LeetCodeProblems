package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxProduct(null))
}

private var totalProduct = 0L
private var totalSum = 0L
private val mod = 1_000_000_007
private fun maxProduct(root: TreeNode?): Int {
    if (root == null) return 0
    totalSum = sumOfTree(root).toLong()
    partSum(root)
    return (totalProduct % mod).toInt()

}

private fun partSum(root: TreeNode?): Long {
    if (root == null) return 0
    val left = partSum(root.left)
    val right = partSum(root.right)
    totalProduct = totalProduct.coerceAtLeast(((totalSum - left) * left).coerceAtLeast((totalSum - right) * right))
    return left + right + root.`val`
}

private fun sumOfTree(root: TreeNode?): Int {
    if (root == null) return 0
    return root.`val` + sumOfTree(root.left) + sumOfTree(root.right)
}