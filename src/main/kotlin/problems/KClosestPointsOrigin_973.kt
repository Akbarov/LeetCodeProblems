package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first.compareTo(o2.first) }
    for ((i, point) in points.withIndex()) {
        pq.offer(Pair(point[0] * point[0] + point[1] * point[1], i))
    }
    val result = Array(k) { IntArray(2) }
    repeat(k) { i ->
        result[i] = points[pq.poll().second]
    }
    return result
}

private fun kClosest2(points: Array<IntArray>, k: Int): Array<IntArray> {
    points.sortWith { o1, o2 -> (o1[0] * o1[0] + o1[1] * o1[1]).compareTo(o2[0] * o2[0] + o2[1] * o2[1]) }
    return points.copyOfRange(0,k)
}
