package problems

import java.util.Stack

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minCost("abaac", intArrayOf(1, 2, 3, 4, 5)))
    println(minCost("aabaa", intArrayOf(1, 2, 3, 4, 1)))
}

private fun minCost(colors: String, neededTime: IntArray): Int {

    var left = 0
    var right = 1
    var cost = 0
    while (right < colors.length) {
        if (colors[left] == colors[right]) {
            right++
        } else {
            if (right - left > 1) {
                cost += getCost(neededTime, left, right)
            }
            left = right
            right++
        }
    }
    if (right - left > 1) {
        cost += getCost(neededTime, left, right)
    }
    return cost
}

private fun getCost(neededTime: IntArray, left: Int, right: Int): Int {
    var sum = 0
    var maxValue = neededTime[left]
    for (i in left until right) {
        sum += neededTime[i]
        if (maxValue < neededTime[i]) maxValue = neededTime[i]
    }
    return sum - maxValue
}