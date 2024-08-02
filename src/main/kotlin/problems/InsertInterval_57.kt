package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var result = insert(
            arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(6, 9)
            ), intArrayOf(2, 5)
    )
    for (ar in result) {
        println(ar.joinToString())
    }
    result = insert(
            arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16),
            ), intArrayOf(4, 8)
    )
    for (ar in result) {
        println(ar.joinToString())
    }

}

private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    if (intervals.isEmpty()) return arrayOf(newInterval)
    val n = intervals.size
    var index = 0
    while (index < n && intervals[index].last() < newInterval.first()) {
        result.add(intervals[index++])
    }
    while (index < n && intervals[index].first() <= newInterval.last()) {
        newInterval[0] = minOf(intervals[index].first(), newInterval.first())
        newInterval[1] = maxOf(intervals[index].last(), newInterval.last())
        index++
    }
    result.add(newInterval)
    while (index < n) {
        result.add(intervals[index++])
    }
    return result.toTypedArray()
}












