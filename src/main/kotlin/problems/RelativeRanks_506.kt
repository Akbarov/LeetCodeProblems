package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun findRelativeRanks(score: IntArray): Array<String> {
    val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 -> p2.first - p1.second }
    val result = Array(score.size) { "" }
    for ((i, item) in score.withIndex()) {
        pq.add(Pair(item, i))
    }
    var count = 1
    while (pq.isNotEmpty()) {
        val p = pq.poll()
        when (count) {
            1 -> {
                result[p.second] = "Gold Medal"
            }
            2 -> {
                result[p.second] = "Silver Medal"
            }
            3 -> {
                result[p.second] = "Bronze Medal"
            }
            else -> {
                result[p.second] = "$count"
            }
        }
        count++
    }
    return result

}