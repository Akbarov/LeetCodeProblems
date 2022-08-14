package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val node = sortedArrayToBST(intArrayOf(2, 3, 4, 5))
}

private fun sortedArrayToBST(nums: IntArray, left: Int = 0, right: Int = nums.size): TreeNode? {
    if (nums.isEmpty()) return null
    return if (left <= right) {
        val mid = (right - left) / 2
        val rootVal = nums[mid]
        val node = TreeNode(rootVal)
        node.left = sortedArrayToBST(nums, left, mid)
        node.right = sortedArrayToBST(nums, mid + 1, right)
        return node
    } else null
}