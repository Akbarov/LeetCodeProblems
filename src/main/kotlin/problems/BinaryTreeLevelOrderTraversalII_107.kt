package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val queue: Queue<TreeNode> = LinkedList()
    val result = mutableListOf<MutableList<Int>>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        var size = queue.size
        val list = mutableListOf<Int>()
        while (size-- > 0) {
            val tempNode = queue.poll()
            tempNode?.`val`?.apply { list.add(this) }
            tempNode.left?.apply { queue.offer(this) }
            tempNode.right?.apply { queue.offer(this) }
        }
        result.add(list)
    }
    return result.reversed()
}