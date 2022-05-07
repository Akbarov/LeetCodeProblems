package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var sum = 0

private fun convertBST(root: TreeNode?): TreeNode? {
    if (root != null) {
        convertBST(root.right)
        sum += root.`val`
        root.`val` = sum
        convertBST(root.left)
    }
    return root
}
