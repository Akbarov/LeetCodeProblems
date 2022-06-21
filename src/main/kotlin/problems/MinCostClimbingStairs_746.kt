package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minCostClimbingStairs2(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
    min(2, 1)
    println(minCostClimbingStairs(intArrayOf(10, 15, 10)))
}

private fun minCostClimbingStairs2(cost: IntArray): Int {
    for (i in 2 until cost.size) {
        cost[i] += min(cost[i - 1], cost[i - 2])
    }
    return min(cost.last(), cost[cost.size - 2])
}

private fun minCostClimbingStairs(cost: IntArray): Int {
    val zero = helper(cost, 0)
    val one = helper(cost, 1)
    return if (zero < one) zero else one
}

private fun helper(cost: IntArray, index: Int): Int {
    if (index >= cost.size) return 0
    val one = helper(cost, index + 1)
    val two = helper(cost, index + 2)
    return cost[index] + if (one < two) one else two
}