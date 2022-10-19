package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findOriginalArray(intArrayOf(1, 4, 2, 1)).joinToString())
}

private fun findOriginalArray(changed: IntArray): IntArray {
    if (changed.size % 2 == 1) return IntArray(0)
    val map = mutableMapOf<Int, Int>()
    val ar = IntArray(changed.size / 2)
    var count = 0
    for (item in changed) {
        map[item] = (map[item] ?: 0) + 1
    }
    for (item in changed) {
        if ((map[item * 2] ?: 0) > 0 && (map[item] ?: 0) > 0) {
            map[item] = (map[item] ?: 0) - 1
            map[item * 2] = (map[item * 2] ?: 0) - 1
            if ((map[item * 2] ?: -1) >= 0) {
                ar[count++] = item
            }
        }
    }

    return if (count == changed.size / 2) ar else IntArray(0)
}