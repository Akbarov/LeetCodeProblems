package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        relativeSortArray(
            intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
            intArrayOf(2, 1, 4, 3, 9, 6)
        ).joinToString()
    )
}

private fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {

    val map = sortedMapOf<Int, Int>()
    arr1.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    var count = 0
    arr2.forEach {
        val size = map[it] ?: 0
        map.remove(it)
        for (i in 0 until size) {
            arr1[count++] = it
        }
    }
    for (m in map) {
        for (i in 0 until m.value) {
            arr1[count++] = m.key
        }
    }
    return arr1
}