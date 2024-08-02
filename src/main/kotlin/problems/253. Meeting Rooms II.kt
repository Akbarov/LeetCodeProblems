package problems

import java.util.PriorityQueue

fun main() {
    println(minMeetingRooms(arrayOf(intArrayOf(7, 10), intArrayOf(2, 4), intArrayOf(7,10))))
}

private fun minMeetingRooms(intervals: Array<IntArray>): Int {
    intervals.sortWith { o1, o2 -> if (o1.first() == o2.first()) o1.last().compareTo(o2.last()) else o1.first().compareTo(o2.first()) }
    var count = 1
    val pq = PriorityQueue<Int> { o1, o2 -> o1.compareTo(o2) }
    for (point in intervals) {
        if (pq.isEmpty()) {
            pq.add(point.last())
        } else {
            if (pq.peek() <= point.first()) {
                pq.poll()
            } else {
                count++
            }
            pq.add(point.last())
        }
    }
    return count
}