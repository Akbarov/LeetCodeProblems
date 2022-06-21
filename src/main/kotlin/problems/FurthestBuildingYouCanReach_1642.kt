package problems

import java.util.*
import kotlin.Comparator

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(furthestBuilding(intArrayOf(2,7,9,12), 5, 1))
}

private fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    var b = bricks
    var l = ladders
    var count = 0
    val queue = PriorityQueue<Int>{a,c->c-a}
    while (count < heights.size - 1) {
        if (heights[count] < heights[count + 1]) {
            val dif = heights[count + 1] - heights[count]
            if (dif <= b) {
                b -= dif
                queue.add(dif)
            } else if (l > 0) {
                if (queue.isNotEmpty() && queue.peek() >= dif) {
                    b += queue.poll()
                    b -= dif
                    queue.offer(dif)
                }
                l--
            } else {
                break
            }
        }
        count++
    }
    return count
}