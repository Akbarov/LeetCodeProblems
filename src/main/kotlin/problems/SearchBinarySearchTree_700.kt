package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null || root.`val` == `val`) return root
    return if (root.`val` < `val`) searchBST(root.left, `val`)
    else searchBST(root.right, `val`)
    

}