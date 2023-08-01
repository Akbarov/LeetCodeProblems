package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(lenLongestFibSubseq(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
}

private fun lenLongestFibSubseq(arr: IntArray): Int {
    var length = 0
    val set = arr.toHashSet()
    for (i in 0 until arr.size - 2) {
        for (j in i + 1 until arr.size - 1) {
            val temp = helper(arr[i], arr[j], set)
            if (temp > length) length = temp
        }
    }
    return if (length < 3) 0 else length
}

private fun helper(first: Int, second: Int, set: Set<Int>): Int {
    var f = first
    var s = second
    var count = 2
    while ((f + s) in set) {
        val t = f
        f = s
        s += t
        count++
    }
    return count
}