package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = merge(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(12, 14)
        )
    )
    for (array in result) {
        println(array.joinToString())
    }
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {

    if (intervals.size <= 1) return intervals

    intervals.sortBy { it.first() }
    var index = 0
    val result = mutableListOf<IntArray>()
    while (index < intervals.size) {
        val temp = intervals[index]
        var count = index + 1
        while (count < intervals.size && temp.last() >= intervals[count].first()) {
            if (temp[1] < intervals[count].last())
                temp[1] = intervals[count].last()
            count++
        }
        index = count
        result.add(temp)
    }

    return result.toTypedArray()
}