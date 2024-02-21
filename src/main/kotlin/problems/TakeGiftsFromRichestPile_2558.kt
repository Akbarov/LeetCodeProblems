package problems

import java.util.*
import kotlin.math.sqrt

/**
Creator: Zohidjon Akbarov
 */

fun main() {

}

private fun pickGifts(gifts: IntArray, k: Int): Long {
    val pq = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    for (item in gifts) {
        pq.add(item)
    }
    repeat(k) {
        pq.add(sqrt(pq.poll().toDouble()).toInt())
    }
    var result = 0L
    while (pq.isNotEmpty()) {
        result += pq.poll()
    }
    return result
}