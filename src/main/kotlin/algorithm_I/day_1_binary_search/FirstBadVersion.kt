package algorithm_I.day_1_binary_search

private val target = 4
fun main() {
    println(firstBadVersion(50))
    println(firstBadVersion(5))
}

private fun firstBadVersion(n: Int): Int {
    var start = 1
    var end = n
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (isBadVersion(mid)) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return start
}

private fun isBadVersion(n: Int): Boolean {
    return target == n
}