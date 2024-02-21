package problems

import java.util.*
import kotlin.math.ceil

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun reorganizeString(s: String): String {
    val sb = StringBuilder()
    val map = mutableMapOf<Char, Int>()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
        if ((map[c] ?: 0) > ceil(s.length / 2.0)) return ""
    }
    val priorityQueue = PriorityQueue<Pair<Char, Int>>(Comparator { o1, o2 -> o2.second.compareTo(o1.second) })
    for (m in map) {
        priorityQueue.offer(Pair(m.key, m.value))
    }

    while (priorityQueue.isNotEmpty()) {
        val top = priorityQueue.poll()
        if (sb.isEmpty() || !sb.endsWith(top.first)) {
            sb.append(top.first)
            if (top.second > 1) {
                priorityQueue.offer(Pair(top.first, top.second - 1))
            }
        }else{
            if (priorityQueue.isEmpty()) return ""
            val second = priorityQueue.poll()
            sb.append(second.first)
            if (second.second > 1) {
                priorityQueue.offer(Pair(second.first,second.second-1))
            }
            priorityQueue.offer(top)
        }
    }
    return sb.toString()
}