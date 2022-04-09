package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2).joinToString())
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 3).joinToString())
    println(topKFrequent(arrayOf("a", "aa", "aaa"), 1).joinToString())
}

private fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val map = mutableMapOf<String, Int>()
    for (item in words) {
        map[item] = (map[item] ?: 0) + 1
    }
    val priorityQueue = PriorityQueue<String> { a, b ->
        if (map[a] == map[b]) a.compareTo(b) else (map[b] ?: 0) - (map[a] ?: 0)

    }
    for (key in map.keys) {
        priorityQueue.offer(key)
    }

    val list = mutableListOf<String>()
    var count = 0
    while (map.isNotEmpty() && count++ < k) {
        list.add(priorityQueue.poll())
    }
    return list.subList(0, k)
}