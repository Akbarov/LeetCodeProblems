package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(arrayRankTransform(intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)).joinToString())
}

private fun arrayRankTransform(arr: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val sortedArray = arr.sortedArray()
    var count = 1
    for (item in sortedArray) {
        if (map[item] == null) {
            map[item] = count++
        }
    }
    val result = IntArray(arr.size)
    for ((i, item) in arr.withIndex()) {
        result[i] = map[item] ?: 0
    }
    return result
}