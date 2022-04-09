package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val kthLargest = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(kthLargest.add(3))
    println(kthLargest.add(5))
    println(kthLargest.add(10))
    println(kthLargest.add(9))
    println(kthLargest.add(4))
}

class KthLargest(val k: Int, nums: IntArray) {

    private val queue = PriorityQueue<Int>()

    init {
        queue.addAll(nums.toList())
        while (queue.size > k) {
            queue.poll()
        }
    }

    fun add(`val`: Int): Int {
        queue.offer(`val`)
        while (queue.size > k)
            queue.poll()
        return queue.peek()
    }

}