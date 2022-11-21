package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(platesBetweenCandles("***|**|*****|**||**|*", arrayOf(intArrayOf(1, 17), intArrayOf(4, 5))).joinToString())
}

private fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    val leftCandle = IntArray(s.length)
    val rightCandle = IntArray(s.length)
    val candles = IntArray(s.length)
    var index = -1
    var count = 0
    for (i in s.indices) {
        if (s[i] == '|') {
            index = i
            count++
        }
        leftCandle[i] = index
        candles[i] = count

    }
    index = -1
    for (i in s.lastIndex downTo 0) {
        if (s[i] == '|') index = i
        rightCandle[i] = index
    }
    for ((i, q) in queries.withIndex()) {
        val left = q[0]
        val right = q[1]
        if (rightCandle[left] == -1 || leftCandle[right] == -1) continue
        val d = leftCandle[right] - rightCandle[left]
        if (d <= 1) continue
        result[i] = d - (candles[leftCandle[right]] - candles[rightCandle[left]])
    }
    return result
}