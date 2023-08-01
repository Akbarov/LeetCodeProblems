package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maxLevelSum(root: TreeNode?): Int {
    if (root == null) return 0
    var sumMax = Int.MIN_VALUE
    var level = 1
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    var count = 0
    while (queue.isNotEmpty()) {
        count++
        val size = queue.size
        var localSum = 0
        repeat(size) {
            val temp = queue.poll()
            localSum += temp.`val`
            temp.left?.apply { queue.offer(this) }
            temp.right?.apply { queue.offer(this) }
        }
        if (localSum > sumMax) {
            sumMax = localSum
            level = count
        }
    }
    return level
}