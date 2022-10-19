package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numsSameConsecDiff(3,7).joinToString())
    println(numsSameConsecDiff(2,1).joinToString())
}

private val result = mutableSetOf<Int>()
private fun numsSameConsecDiff(n: Int, k: Int): IntArray {
    for (number in 1..9) {
        helper(number.toString(), n, k)
    }
    return result.toIntArray()
}

private fun helper(s: String, n: Int, k: Int) {
    if (s.length == n) {
        result.add(s.toInt())
        return
    }
    val lastNumber = s.last() - '0'
    if (lastNumber + k < 10) {
        helper(s + (lastNumber + k), n, k)
    }
    if (lastNumber - k >= 0) {
        helper(s + (lastNumber - k), n, k)
    }
}