package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val result = insert(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9)
        ), intArrayOf(2, 5)
    )
    for (ar in result) {
        println(ar.joinToString())
    }

}

private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    var count = 0
    while (count < intervals.lastIndex) {
        if (intervals[count].first() <= newInterval.first()) {
            return if (intervals[count + 1].first() > newInterval.last()) {
                intervals[count][1] = newInterval.last()
                intervals
            } else {
                var index = count
                while (intervals[index + 1].first() > newInterval.last()) {
                    index++
                }
                intervals[index][0] = intervals[count][0]
                val result = mutableListOf<IntArray>()
                for (i in intervals.indices) {
                    if (i !in count until index) {
                        result.add(intervals[i])
                    }
                }
                result.toTypedArray()
                intervals
            }
        } else if (intervals[count].first() > newInterval.first())
            return intervals
        count++
    }
    return intervals
}