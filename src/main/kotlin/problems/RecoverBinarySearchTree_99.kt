package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun recoverTree(root: TreeNode?) {

    val list = mutableListOf<TreeNode>()
    inorder(root, list)
    for (i in list.lastIndex downTo 1) {
        var isFound = false
        var index = 0
        for (j in i - 1 downTo 0) {
            if (list[i].`val` > list[j].`val`) break
            isFound = true
            index = j
        }
        if (isFound) {
            val temp = list[i].`val`
            list[i].`val` = list[index].`val`
            list[index].`val` = temp
            return
        }
    }
}

private fun inorder(root: TreeNode?, list: MutableList<TreeNode>) {
    if (root == null) return
    inorder(root.left, list)
    list.add(root)
    inorder(root.right, list)
}