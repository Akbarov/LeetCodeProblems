package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

//iteration
private fun levelOrderIt(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val list = mutableListOf<MutableList<Int>>()
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val sub = mutableListOf<Int>()
        val level = queue.size
        for (i in 0 until level) {
            if (queue.peek().left != null) queue.offer(queue.peek().left)
            if (queue.peek().right != null) queue.offer(queue.peek().right)
            sub.add(queue.poll().`val`)
        }
        list.add(sub)
    }
    return list
}

// recursion
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val list = mutableListOf<MutableList<Int>>()
    helper(root, list, 0)
    return list
}

private fun helper(root: TreeNode?, list: MutableList<MutableList<Int>>, level: Int) {
    if (root == null) return
    if (list.size == level) {
        list.add(mutableListOf())
    }
    list[level].add(root.`val`)
    helper(root.left, list, level + 1)
    helper(root.right, list, level + 1)
}