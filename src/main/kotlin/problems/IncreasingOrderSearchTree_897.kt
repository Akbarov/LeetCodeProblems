package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var base: TreeNode? = null
private var prev: TreeNode? = null
private fun increasingBST(root: TreeNode?): TreeNode? {
    if (root == null) return null
    increasingBST(root.left)

    if (base == null) {
        base = root
        prev = root
    } else if (prev != null) {
        prev?.right = TreeNode(root.`val`)
        prev = prev?.right
    }
    increasingBST(root.right)
    return base
}

private var cur: TreeNode? = null
private fun increasingBST2(root: TreeNode?): TreeNode? {
    val ans = TreeNode(0)
    cur = ans
    inorder(root)
    return ans.right
}

private fun inorder(root: TreeNode?) {
    if (root == null) return
    inorder(root)
    root.left = null
    cur?.right = cur
    cur = cur?.right
    inorder(root)
}