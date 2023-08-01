package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(rightSideView(TreeNode.generateTreeNode(listOf(1, 2, 3, null, 5, null, 4))))
}

private fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int>()
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    var number = root.`val`
    result.add(number)
    while (queue.isNotEmpty()) {
        var size = queue.size
        while (size-- > 0) {
            val temp = queue.poll()
            temp.left?.apply {
                queue.add(this)
                number = this.`val`
            }
            temp.right?.apply {
                queue.add(this)
                number = this.`val`
            }
        }
        println(number)
        result.add(number)
    }
    return result
}