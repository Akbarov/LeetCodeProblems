package problems

import java.util.*
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minimumTime2(n: Int, relations: Array<IntArray>, time: IntArray): Int {

    val startingPoint = IntArray(n)
    val graph = Array(n) { mutableListOf<Int>() }
    for (point in relations) {
        graph[point[0] - 1].add(point[1] - 1)
        startingPoint[point[1] - 1]++
    }
    val result = IntArray(n)
    val queue: Queue<Int> = LinkedList()
    for (start in startingPoint) {
        if (start == 0) {
            queue.add(start)
        }
    }
    while (queue.isNotEmpty()) {
        val prev = queue.poll()
        for (next in graph[prev]) {
            result[next] = max(result[next], result[prev] + time[next])
            if (--startingPoint[next] == 0) {
                queue.add(next)
            }
        }
    }
    return result.maxOrNull() ?: -1

}

private fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
    val head = BooleanArray(n) { true }
    val dp = Array(n) { mutableListOf<Course>() }
    for (point in relations) {
        dp[point[1] - 1].add(Course(point[0] - 1, time[point[1] - 1]))
        head[point[0] - 1] = false
    }
    for ((position, isHead) in head.withIndex()) {
        if (isHead) {
            return dfs(position, dp, time[position])
        }
    }
    return -1
}

private fun dfs(position: Int, dp: Array<MutableList<Course>>, currentTime: Int): Int {
    var longestTime = 0
    if (dp[position].isNotEmpty()) return currentTime
    for (preCourse in dp[position]) {
        val neededTime = dfs(preCourse.prev, dp, currentTime + preCourse.time)
        longestTime = max(longestTime, neededTime)
    }
    return longestTime
}

private data class Course(val prev: Int, val time: Int)