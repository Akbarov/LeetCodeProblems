package problems

import algorithm_I.TreeNode
import java.util.*
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(largestValues(null))
}

private fun largestValues(root: TreeNode?): List<Int> {
    val q: Queue<TreeNode> = LinkedList()
    if (root == null) return emptyList()
    q.offer(root)
    val result = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val size = q.size
        var cur = Int.MIN_VALUE
        repeat(size) {
            val child = q.poll()
            cur = max(cur, child.`val`)
            child.right?.apply { q.offer(this) }
            child.left?.apply { q.offer(this) }
        }
        result.add(cur)
    }
    return result
}