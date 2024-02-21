package problems

import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private val memo = mutableMapOf<Int, MutableList<TreeNode?>>()
private fun allPossibleFBT(n: Int): List<TreeNode?> {
    val list = mutableListOf<TreeNode?>()
    if (n % 2 == 0) return list
    if (n == 1) {
        list.add(TreeNode(0))
        return list
    }
    memo[n]?.apply {
        return this
    }
    val t = n - 1
    for (i in 1 until t step 2) {
        val left = allPossibleFBT(i)
        val right = allPossibleFBT(t - i)
        for (l in left) {
            for (r in right) {
                val current = TreeNode(0)
                current.left = l
                current.right = r
                list.add(current)
            }
        }
    }
    memo[n] = list
    return list

}
