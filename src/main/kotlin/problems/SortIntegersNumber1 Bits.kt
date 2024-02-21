package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(sortByBits(intArrayOf(0, 1, 2, 3, 4, 45)).joinToString())
}

private fun sortByBits(arr: IntArray): IntArray {
    val list = PriorityQueue<Pair<Int, Int>>(Comparator { o1, o2 ->
        if (o1.first == o2.first) o1.second.compareTo(o2.second) else o1.first.compareTo(o2.first)
    })
    for (item in arr) {
        list.add(Pair(item.countOneBits(), item))
    }
    val result = IntArray(arr.size)
    for (i in result.indices) {
        result[i] = list.poll().second
    }
    return result

}