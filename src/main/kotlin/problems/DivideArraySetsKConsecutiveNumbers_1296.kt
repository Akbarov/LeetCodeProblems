package problems

import java.util.PriorityQueue

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
    val priorityQueue = PriorityQueue<Int>()
    nums.forEach {
        priorityQueue.add(it)
    }
    while (priorityQueue.isNotEmpty()) {
        val start = priorityQueue.poll()
        for (i in 1 until k) {
            if (!priorityQueue.remove(start + i)) {
                return false
            }
        }
    }
    return true
}