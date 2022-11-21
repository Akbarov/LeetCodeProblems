package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findOrder(2, arrayOf(intArrayOf(1, 0))))
}

private fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val dp = Array(numCourses) { mutableListOf<Int>() }
    val linkCount = IntArray(numCourses)
    for (array in prerequisites) {
        dp[array[1]].add(array[0])
        linkCount[array[0]]++
    }
    val queue: Queue<Int> = LinkedList()
    for ((index, item) in linkCount.withIndex()) {
        if (item == 0) {
            queue.offer(index)
        }
    }
    var visited = 0
    val result = IntArray(numCourses)
    while (queue.isNotEmpty()) {
        val link = queue.poll()
        result[visited++] = link
        for (i in dp[link]) {
            linkCount[i]--
            if (linkCount[i] == 0) queue.offer(i)
        }
    }
    return if (visited == numCourses) result else intArrayOf()

}