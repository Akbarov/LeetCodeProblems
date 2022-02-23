package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
val root = TreeNode(2)
val right = TreeNode(3)
    root.right = right
    println(binaryTreePaths(root).joinToString())
}

private val list = mutableListOf<String>()
private fun binaryTreePaths(root: TreeNode?): List<String> {
    if (root == null) return list
    addPath(root, StringBuilder())
    return list
}

private fun addPath(root: TreeNode?, s: StringBuilder) {
    if (root==null)return
    if (root.left == null && root.right == null) {
        if (s.isEmpty())s.append(root.`val`)
        else s.append("->${root.`val`}")
        list.add(s.toString())
        return
    }
    if (s.isEmpty()) s.append(root.`val`)
    else s.append("->${root.`val`}")
    addPath(root.left, StringBuilder(s))
    addPath(root.right, StringBuilder(s))
}