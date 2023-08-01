package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
}

private fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val prCap = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 -> o1.first().compareTo(o2.first()) })
    val prPro = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 -> o2.last().compareTo(o1.last()) })
    for (i in profits.indices) {
        prCap.offer(intArrayOf(capital[i], profits[i]))
    }
    var result = w
    repeat(k) {
        while (prCap.isNotEmpty() && prCap.peek().first() <= result) {
            prPro.offer(prCap.poll())
        }
        if (prPro.isNotEmpty()) {
            result += prPro.poll().last()
        }
    }
    return result
}