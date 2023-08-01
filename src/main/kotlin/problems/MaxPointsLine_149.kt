package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxPoints(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))))
}

private fun maxPoints(points: Array<IntArray>): Int {

    var result = 0

    for (i in points.indices) {
        val map = mutableMapOf<String, Int>()
        val start = points[i]
        for (j in i + 1 until points.size) {
            val end = points[j]
            val s: String = if (start[0] == end[0]) {
                "y=${start[0]}"
            } else if (start[1] == end[1]) {
                "x=${start[1]}"
            } else {
                val m = 1.0 * (start[1] - end[1]) / (start[0] - end[0])
                val b = start[1] - m * start[0]
                "y=$m*x+$b"
            }
            map[s] = (map[s] ?: 0) + 1
            if (result < map[s]!!) result = map[s]!!
        }
    }
    return result
}