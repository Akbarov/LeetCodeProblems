package problems

import java.util.*
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minimumDeviation(intArrayOf(1, 2, 3, 4)))
}

private fun minimumDeviation(nums: IntArray): Int {
    val priorityQueue = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o2.compareTo(o1) })
    var smallest = Int.MAX_VALUE
    for (item in nums) {
        val t = if (item % 2 == 1) item * 2 else item
        priorityQueue.offer(t)
        println(t)
        smallest = min(smallest, t)
    }

    println()
    println()

    var result = Int.MAX_VALUE
    while (priorityQueue.peek() % 2 == 0) {
        val poll = priorityQueue.poll()
        result = min(result, poll - smallest)
        smallest = min(poll / 2, smallest)
        priorityQueue.add(poll / 2)
        println(result)

    }
    return min(result, priorityQueue.peek() - smallest)

}