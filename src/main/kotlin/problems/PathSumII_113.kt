package problems

import algorithm_I.TreeNode

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private val result = mutableListOf<MutableList<Int>>()
private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    if (root == null) return result
    helper(root, targetSum, mutableListOf(root.`val`))
    return result
}

private fun helper(root: TreeNode?, targetSum: Int, list: MutableList<Int>) {
    if (root == null) return
    if (targetSum == root.`val` && root.left == null && root.right == null) {
        val tempList = mutableListOf<Int>()
        tempList.addAll(list)
        result.add(tempList)
        return
    }

    root.left?.apply {
        list.add(`val`)
        helper(this, targetSum - `val`, list)
        list.removeAt(list.size - 1)
    }
    root.right?.apply {
        list.add(`val`)
        helper(this, targetSum - `val`, list)
        list.removeAt(list.size - 1)
    }
}