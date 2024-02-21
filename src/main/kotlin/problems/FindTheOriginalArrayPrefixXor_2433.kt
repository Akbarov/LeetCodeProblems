package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(findArray(intArrayOf(5, 2, 0)).joinToString())
}

private fun findArray(pref: IntArray): IntArray {
    val result = IntArray(pref.size)
    result[0] = pref[0]
    for (i in 1 until result.size) {
        result[i] = pref[i - 1] xor pref[i]
    }
    return result
}

