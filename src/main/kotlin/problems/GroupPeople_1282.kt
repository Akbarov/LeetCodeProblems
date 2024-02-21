package problems

import java.util.LinkedList
import java.util.Queue

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = groupThePeople(intArrayOf(2, 1, 3, 3, 3, 2))
    for (row in result) {
        println(row.joinToString())
    }
}

private fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val map = mutableMapOf<Int, MutableList<Int>>()
    for ((index, item) in groupSizes.withIndex()) {
        if (map[item] == null) {
            map[item] = mutableListOf(index)
        } else {
            map[item]?.add(index)
        }
    }
    val sortedMap = map.toSortedMap()
    val result = mutableListOf<List<Int>>()
    for ((key, list) in sortedMap) {
        if (key == list.size) {
            result.add(list)
        } else {
            var start = 0
            var end = key
            while (end <= list.size) {
                result.add(list.subList(start, end))
                start = end
                end += key
            }
        }
    }
    return result
}