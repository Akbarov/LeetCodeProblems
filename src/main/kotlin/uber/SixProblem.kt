package uber

import algorithm_I.TreeNode

fun main() {

}

private var result = 0
private fun pathSum(root: TreeNode?, targetSum: Int): Int {
    val map = mutableMapOf<Long, Int>()
    map[0] = 1
    return getCount(root, targetSum, map, 0L)
}

private fun getCount(root: TreeNode?, targetSum: Int, map: MutableMap<Long, Int>, sum: Long): Int {
    if (root == null) return 0
    val prefixSum = sum + root.`val`
    var count = map[prefixSum - targetSum] ?: 0
    map[prefixSum] = (map[prefixSum] ?: 0) + 1
    count += getCount(root.left, targetSum, map, prefixSum)
    count += getCount(root.right, targetSum, map, prefixSum)
    return count
}

