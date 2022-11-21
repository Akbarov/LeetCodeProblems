package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3), intArrayOf(3, 4))))
}

private fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortWith(Comparator { o1, o2 -> o1[1].compareTo(o2[1]) })
    var end = intervals[0][1]
    var count = 0
    for (i in 1 until intervals.size) {
        if (intervals[i][0] >= end) {
            end = intervals[i][1]
            count++
        }
    }
    return intervals.size - count
}