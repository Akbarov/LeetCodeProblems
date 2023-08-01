package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
    var result = 0
    val dp = IntArray(n) { -1 }
    for (i in manager.indices) {
        if (i != headID) {
            result = max(result, helper(manager, informTime, dp, i))
        }
    }
    return result
}

private fun helper(manager: IntArray, informTime: IntArray, dp: IntArray, currentEmployee: Int): Int {
    if (dp[currentEmployee] >= 0) return dp[currentEmployee]
    if (manager[currentEmployee] == -1) return informTime[currentEmployee]
    dp[currentEmployee] = helper(manager, informTime, dp, manager[currentEmployee]) + informTime[currentEmployee]
    return dp[currentEmployee]
}