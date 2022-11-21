package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minimumOperations(root: TreeNode?): Int {
    val queue: Queue<TreeNode> = LinkedList()
    if (root == null) return 0
    var result = 0
    queue.offer(root)
    while (queue.isNotEmpty()) {
        var size = queue.size
        val list = mutableListOf<Int>()
        while (size-- > 0) {
            val temp = queue.poll()
            list.add(temp.`val`)
            temp.left?.apply { queue.offer(this) }
            temp.right?.apply { queue.offer(this) }
        }
        result += sortList(list)
    }
    return result
}

private fun sortList(list: List<Int>): Int {
    var count = 0
    if (list.size <= 1) return 0
    val tempList = Array(list.size) { IntArray(2) }
    for ((i, item) in list.withIndex()) {
        tempList[i] = intArrayOf(item, i)
    }
    tempList.sortWith(kotlin.Comparator { o1, o2 -> o1[0].compareTo(o2[0]) })
    var i = 0
    while (i < tempList.size) {
        if (i == tempList[i][1]) {
            i++
            continue
        }
        count++
        val t = tempList[i]
        tempList[i] = tempList[t[1]]
        tempList[t[1]] = t
    }
    return count
}