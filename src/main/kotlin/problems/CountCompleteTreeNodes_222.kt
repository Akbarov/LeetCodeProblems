package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countNodes(TreeNode(1)))
}

private fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0
    var h = 1
    var ans = 0
    val q: Queue<TreeNode> = LinkedList()
    q.add(root)
    while (q.isNotEmpty()) {
        var size = q.size
        if (h != size) {
            return ans + size
        }
        h *= 2

        while (size-- > 0) {
            val temp = q.poll()
            ans++
            temp.left?.apply { q.add(this) }
            temp.right?.apply { q.add(this) }
        }
    }
    return ans
}