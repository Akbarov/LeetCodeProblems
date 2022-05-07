package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
kthSmallest(TreeNode(1),1)
    println(result)
}


private var result = 0
private var counter = 0
private fun kthSmallest(root: TreeNode?, k: Int): Int {
    inorder(root, k)
    return result
}

private fun inorder(root: TreeNode?, k: Int) {
    if (root == null) return
    inorder(root.left, k)
    counter++
    if (counter == k) {
        result = root.`val`
    }
    inorder(root.right, k)
    return
}