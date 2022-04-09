package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(topKFrequentWithQueue(intArrayOf(1, 1, 1, 2, 2, 3), 2).joinToString())
    println(topKFrequentWithQueue(intArrayOf(1), 1).joinToString())
}

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    var map = mutableMapOf<Int, Int>()
    for (i in nums) {
        map[i] = (map[i] ?: 0) + 1
    }
    map = map.toList().sortedByDescending { it.second }.toMap() as MutableMap<Int, Int>
    val result = IntArray(k)
    var counter = 0
    for (i in map.keys) {
        if (counter >= k) {
            break
        }
        result[counter] = i
        counter++
    }
    return result
}

private fun topKFrequentWithQueue(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums) {
        map[i] = (map[i] ?: 0) + 1
    }
    val priorityQueue = PriorityQueue<Int> { a, b -> (map[a] ?: 0) - (map[b] ?: 0) }
    for (key in map.keys) {
        priorityQueue.add(key)
    }
    while (priorityQueue.size > k) {
        priorityQueue.poll()
    }
    return priorityQueue.toIntArray()
}