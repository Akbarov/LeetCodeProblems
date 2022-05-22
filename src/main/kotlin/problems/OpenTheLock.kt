package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(openLock(arrayOf("8888"), "0009"))
    println(openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202"))
}

private fun openLock(deadends: Array<String>, target: String): Int {
    if ("0000" in deadends) return -1
    val visitedSet = mutableSetOf<String>()
    val deadSet = deadends.toSet()
    val q: Queue<String> = LinkedList()
    q.offer("0000")
    var level = 0
    while (q.isNotEmpty()) {
        var size = q.size
        while (size-- > 0) {
            val cur = q.poll()
            if (cur == target) {
                return level
            }
            if (cur in deadSet) {
                continue
            }
            val children = getChildren(cur)
            for (item in children) {
                if (item !in visitedSet && item !in deadSet) {
                    visitedSet.add(item)
                    q.offer(item)
                }
            }
        }
        level++
    }
    return -1
}

private fun getChildren(s: String): List<String> {
    val result = mutableListOf<String>()
    for (i in 0 until 4) {
        var temp = ((s[i] - '0') + 1) % 10
        result.add("${s.substring(0, i)}$temp${s.substring(i + 1, 4)}")
        temp = ((s[i] - '0') - 1 + 10) % 10
        result.add("${s.substring(0, i)}$temp${s.substring(i + 1, 4)}")
    }
    return result
}