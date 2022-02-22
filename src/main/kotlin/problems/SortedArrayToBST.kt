package problems

import algorithm_I.TreeNode

fun main() {

}

private fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return createNode(nums, 0, nums.lastIndex)
}

private fun createNode(nums: IntArray, l: Int, r: Int): TreeNode? {
    val middle = l + (r - l + 1) / 2
    return if (r >= l) {
        TreeNode(
            nums[middle]
        ).also {
            it.left = createNode(nums, l, middle - 1)
            it.right = createNode(nums, middle + 1, r)
        }

    } else {
        null
    }
}