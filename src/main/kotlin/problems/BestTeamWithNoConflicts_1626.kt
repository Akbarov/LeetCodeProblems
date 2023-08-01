package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(bestTeamScore(intArrayOf(1, 2, 4, 5, 6, 7, 10), intArrayOf(1, 2, 3, 4, 5, 6, 7)))
}

private fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
    val team = Array(scores.size) { i -> intArrayOf(ages[i], scores[i]) }
    team.sortWith(Comparator { o1, o2 -> if (o1[0] != o2[0]) o1[0].compareTo(o2[0]) else o1[1].compareTo(o2[1]) })
    val dp = IntArray(scores.size)
    dp[0] = team[0][1]
    for (i in 1 until scores.size) {
        var maxValue = team[i][1]
        for (j in 0 until i) {
            if (team[i][1] >= team[j][1]) {
                maxValue = max(maxValue, dp[j] + team[i][1])

            }
        }
        dp[i] = maxValue
    }
    return dp.maxOrNull() ?: 0
}