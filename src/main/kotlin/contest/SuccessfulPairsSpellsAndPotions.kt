package contest

import kotlin.math.ceil

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(successfulPairs(intArrayOf(5, 1, 3), intArrayOf(1, 2, 3, 4, 5), 7).joinToString())
}

private fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    for ((i, item) in potions.withIndex()) {
        potions[i] = ceil(success * 1.0 / item).toInt()
    }
    potions.sort()
    val result = IntArray(spells.size)
    for ((i, item) in spells.withIndex()) {
        var r = potions.lastIndex
        var l = 0
    }
    return result
}