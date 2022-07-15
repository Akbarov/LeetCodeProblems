package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val queue: Queue<TreeNode> = LinkedList()
    val resultList = mutableListOf<MutableList<Int>>()
    if (root == null) return resultList
    queue.offer(root)
    resultList.add(mutableListOf(root.`val`))
    var height = 1
    while (queue.isNotEmpty()) {
        val size = queue.size
        val tempList = mutableListOf<Int>()
        for (i in 0 until size) {
            val current = queue.poll()
            tempList.add(current.`val`)
            if (current.left != null) queue.add(current.left)
            if (current.right != null) queue.add(current.right)
        }
        if (height % 2 == 0) tempList.reverse()
        resultList.add(tempList)
        height++
    }
    return resultList
}

private fun zigzagLevelOrder2(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val leftToRight = Stack<TreeNode>()
    val rightToLeft = Stack<TreeNode>()
    val resultList = mutableListOf<MutableList<Int>>()
    leftToRight.add(root)
    while (leftToRight.isNotEmpty() || rightToLeft.isNotEmpty()) {
        var tempList = mutableListOf<Int>()
        while (leftToRight.isNotEmpty()) {
            val temp = leftToRight.pop()
            tempList.add(temp.`val`)
            if (temp.left != null) rightToLeft.add(temp.left)
            if (temp.right != null) rightToLeft.add(temp.right)
        }
        if (tempList.isNotEmpty()) resultList.add(tempList)

        tempList = mutableListOf()
        while (rightToLeft.isNotEmpty()) {
            val temp = rightToLeft.pop()
            tempList.add(temp.`val`)
            if (temp.right != null) leftToRight.add(temp.right)
            if (temp.left != null) leftToRight.add(temp.left)
        }
        if (tempList.isNotEmpty()) resultList.add(tempList)
    }
    return resultList
}