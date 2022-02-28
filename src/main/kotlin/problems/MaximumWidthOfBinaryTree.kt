package problems

import algorithm_I.TreeNode
import java.util.Queue
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun widthOfBinaryTree(root: TreeNode?): Int {
    var queue = ArrayDeque(listOf(Pair(root, 1)))
    var maxWidth = 1
    while (queue.isNotEmpty()) {
        var head = queue.last()
        var tail = head
        for (i in queue.size downTo 1) {
            tail = queue.removeFirst()
            if (tail.first?.left != null) {
                queue.add(Pair(tail.first?.left, 2 * tail.second))
            }
            if (tail.first?.right != null) {
                queue.add(Pair(tail.first?.right, 2 * tail.second))
            }
        }
        maxWidth = max(maxWidth,tail.second-head.second+1)
    }
    return maxWidth
}

private fun width(root: TreeNode?) {

}