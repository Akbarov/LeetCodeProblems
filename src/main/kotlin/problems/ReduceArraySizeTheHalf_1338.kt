package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    minSetSize(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7))
}

private fun minSetSize(arr: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    arr.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    val list = map.values.sortedDescending()
    var count = 0
    var sum = 0
    list.forEach {
        sum += it
        count++
        if (arr.size <= sum * 2) {
            return count
        }
    }
    return count
}