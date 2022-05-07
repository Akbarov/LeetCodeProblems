package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(guessNumber(n = 2_126_753_390))
}

private val guessedNumber = 1_702_766_719
private fun guessNumber(n: Int): Int {
    var l = 0L
    var r = n
    while (l <= r) {
        val mid = ((l + r) / 2).toInt()
        when (guess(mid)) {
            0 -> return mid
            1 -> l = (mid + 1).toLong()
            else -> r = mid - 1
        }
    }
    return -1
}

private fun helper(start: Long, n: Int): Int {
    val mid = (n + start) / 2
    return when (guess(mid.toInt())) {
        0 -> mid.toInt()
        -1 -> helper(start, mid.toInt() - 1)
        else -> helper(mid + 1, n)
    }
}

private fun guess(n: Int): Int {
    return when {
        n == guessedNumber -> 0
        n > guessedNumber -> -1
        else -> 1
    }
}