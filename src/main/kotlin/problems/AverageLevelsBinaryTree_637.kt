package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun averageOfLevels2(root: TreeNode?): DoubleArray {
    if (root == null) return doubleArrayOf()
    val queue:Queue<TreeNode> = LinkedList<TreeNode>()
    val list = mutableListOf<Double>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var sum = 0.0
        for (i in 0 until size) {
            val temp = queue.poll()
            sum += temp.`val`
            if (temp.left != null) queue.offer(temp.left)
            if (temp.right != null) queue.offer(temp.right)
        }
        list.add(sum / size)
    }
    return list.toDoubleArray()
}

private val result = mutableListOf<MutableList<Double>>()
private fun averageOfLevels(root: TreeNode?): DoubleArray {
    if (root == null) return doubleArrayOf()
    helper(root, 0)
    val d = DoubleArray(result.size)
    for (i in result.indices) {
        val temp = result[i]
        d[i] = temp.sum() / temp.size
    }
    return d
}

private fun helper(root: TreeNode?, index: Int) {
    if (root == null) return
    if (result.size > index) result[index].add(root.`val`.toDouble())
    else result.add(mutableListOf(root.`val`.toDouble()))
    helper(root.left, index + 1)
    helper(root.right, index + 1)
}