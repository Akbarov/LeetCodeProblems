package algorithm_I

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    companion object{
        fun generateTreeNode(list: List<Int?>): TreeNode? {
            if (list.isEmpty() || list[0] == null) return null
            var index = 0
            val head = TreeNode(list[index]!!)
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(head)
            while (queue.isNotEmpty() && index < list.size) {
                val temp = queue.poll()
                index++
                if (index < list.size && list[index] != null) {
                    temp.left = TreeNode(list[index]!!)
                } else {
                    temp.left = null
                }
                index++
                if (index < list.size && list[index] != null) {
                    temp.right = TreeNode(list[index]!!)
                } else {
                    temp.right = null
                }
            }
            return head
        }
    }
}