package problems

import algorithm_I.TreeNode


/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return null

    return if (key < root.`val`) {
        root.left = deleteNode(root.left, key)
        root
    } else if (key > root.`val`) {
        root.right = deleteNode(root.right, key)
        root
    } else {
        if (root.left == null) {
            root.right
        } else if (root.right == null) {
            root.left
        } else {
            var min = root.right
            while (min!!.left != null) {
                min = min.left
            }
            root.`val` = min.`val`
            root.right = deleteNode(root.right, min.`val`)
            root
        }
    }
}