package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println()
    println()
}

private fun frequencySort(nums: IntArray): IntArray {

    val map = mutableMapOf<Int, Int>()
    for (c in nums) {
        map[c] = (map[c] ?: 0) + 1
    }
    val queue = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first != b.first) a.first - b.first
        else
            b.second - a.second

    }
    for (m in map) {
        queue.add(Pair(m.value, m.key))
    }
    val result = IntArray(nums.size)
    var index = 0
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until p.first) {
            result[index] = p.second
        }
    }
    return result
}