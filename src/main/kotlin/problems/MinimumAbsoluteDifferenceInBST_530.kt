package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

var minDiff = Int.MAX_VALUE
private lateinit var list: MutableList<Int>
private fun getMinimumDifference(root: TreeNode?): Int {
    list = mutableListOf()
    if (root?.left == null && root?.right == null) return 0
    inorder(root)
    println(list.joinToString())
    if (list.size < 2) return 0
    minDiff = list[1] - list[0]
    var i = 1
    while (i < list.lastIndex) {
        if (minDiff > list[i + 1] - list[i]) {
            minDiff = list[i + 1] - list[i]
        }
        i++
    }
    return minDiff
}

private fun inorder(root: TreeNode?) {
    if (root == null) return
    inorder(root.left)
    list.add(root.`val`)
    inorder(root.right)
}