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
    var inserted = false
    for (item in intervals) {
        if (item.last() < newInterval.first()) {
            result.add(item)
            continue
        }
        if (item.first() > newInterval.last()) {
            if (!inserted) {
                result.add(newInterval)
                inserted = true
            }
            result.add(item)
            continue
        }
        if (item.first() <= newInterval.first() && item.last() >= newInterval.first()) {
            newInterval[0] = item.first()
        }
        if (item.first() <= newInterval.last() && item.last() >= newInterval.last()) {
            newInterval[1] = item.last()
        }

    }
    if (result.isEmpty()) {
        result.add(newInterval)
        inserted = true
    }
    if (!inserted && result.last().last() < newInterval.first()) {
        result.add(newInterval)
    }
    return result.toTypedArray()
}