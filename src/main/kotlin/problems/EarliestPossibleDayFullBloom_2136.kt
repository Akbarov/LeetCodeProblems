package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(earliestFullBloom(intArrayOf(1, 4, 3), intArrayOf(2, 3, 1)))
    println(earliestFullBloom(intArrayOf(1, 2, 3, 2), intArrayOf(2, 1, 2, 1)))
}

private fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val bloom = Array(plantTime.size) { i -> intArrayOf(growTime[i], plantTime[i], growTime[i] + plantTime[i]) }
    bloom.sortWith(Comparator { a1, a2 -> if (a2[0] != a1[0]) a2[0] - a1[0] else a1[1] - a2[1] })

    var openDay = bloom[0][0]
    var days = bloom[0][1]
    println(bloom[0].joinToString(","))
    for (i in 1 until bloom.size) {
        val array = bloom[i]
        println(array.joinToString(","))
        days += array[1]
        openDay -= array[1]
        openDay = max(openDay, array[0])
    }
    return days + openDay

}