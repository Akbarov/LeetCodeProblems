package problems

import java.util.PriorityQueue

fun main() {
    println(customSortString("cba", "dacb"))
    println(customSortString2("cba", "dacb"))
}

private fun customSortString(order: String, s: String): String {
    val map = mutableMapOf<Char, Int>()
    for ((index, c) in order.withIndex()) {
        map[c] = index
    }
    val pq = PriorityQueue<Pair<Char, Int>> { o1, o2 -> o1.second.compareTo(o2.second) }
    for (c in s) {
        pq.add(Pair(c, map[c] ?: Int.MAX_VALUE))
    }
    val sb = StringBuilder()
    while (pq.isNotEmpty()) {
        sb.append(pq.poll().first)
    }
    return sb.toString()
}

private fun customSortString2(order: String, s: String): String {
    val map = mutableMapOf<Char, Int>()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
    }
    val sb = StringBuilder()
    for (c in order) {
        sb.append(c.toString().repeat(map[c] ?: 0))
        map.remove(c)
    }
    for ((char, count) in map) {
        sb.append(char.toString().repeat(count))
    }
    return sb.toString()
}