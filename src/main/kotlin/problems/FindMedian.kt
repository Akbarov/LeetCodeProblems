package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */

fun main() {
    val medianFinder = MedianFinder()
    medianFinder.addNum(1)
    medianFinder.addNum(4)
    medianFinder.addNum(3)
    println(medianFinder.findMedian())
}

class MedianFinder() {

    val large = PriorityQueue<Double>()
    val small = PriorityQueue<Double>()

    fun addNum(num: Int) {
        large.add(num.toDouble())
        small.add(-large.poll())
        if (large.size < small.size) {
            large.add(-small.poll())
        }
    }

    fun findMedian(): Double {
        return if (large.size > small.size) return large.peek() else (large.peek() - small.peek()) / 2
    }
}