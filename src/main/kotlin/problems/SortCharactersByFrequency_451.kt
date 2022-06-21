package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(frequencySort("tree"))
    println(frequencySort("aaaccc"))
}

private fun frequencySort(s: String): String {
    println(s.count { it=='e' }/s.length)
    val map = mutableMapOf<Char, Int>()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
    }
    val queue = PriorityQueue<Pair<Int, Char>> { a, b -> b.first - a.first }
    for (m in map) {
        queue.add(Pair(m.value, m.key))
    }
    val sb = StringBuilder()
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until p.first) {
            sb.append(p.second)
        }
    }
    return sb.toString()
}