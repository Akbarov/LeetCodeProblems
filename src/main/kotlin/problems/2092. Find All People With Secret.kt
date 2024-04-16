package problems

import java.util.*
import kotlin.math.max
import kotlin.math.min


fun main() {

}

fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val groups = IntArray(100000)
    val result: MutableList<Int> = ArrayList()
    val temp: MutableList<Int> = ArrayList()

    for (i in 0 until n) groups[i] = i
    groups[firstPerson] = 0

    Arrays.sort(meetings) { a: IntArray, b: IntArray -> a[2].compareTo(b[2]) }

    var i = 0
    while (i < meetings.size) {
        val currentTime = meetings[i][2]
        temp.clear()
        while (i < meetings.size && meetings[i][2] == currentTime) {
            val g1 = find(groups, meetings[i][0])
            val g2 = find(groups, meetings[i][1])
            groups[max(g1, g2)] = min(g1, g2)
            temp.add(meetings[i][0])
            temp.add(meetings[i][1])
            ++i
        }
        for (j in temp.indices) {
            if (find(groups, temp[j]) != 0) {
                groups[temp[j]] = temp[j]
            }
        }
    }

    for (j in 0 until n) {
        if (find(groups, j) == 0) result.add(j)
    }

    return result
}

private fun find(groups: IntArray, index: Int): Int {
    var index = index
    while (index != groups[index]) index = groups[index]
    return index
}