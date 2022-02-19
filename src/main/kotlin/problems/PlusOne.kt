package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(plusOne(intArrayOf(1, 2, 3)).joinToString())
    println(plusOne(intArrayOf(9)).joinToString())
    println(plusOne(intArrayOf(9, 9, 9, 9, 9)).joinToString())
}

private fun plusOne(digits: IntArray): IntArray {
    var plusDigit = 1
    for (i in digits.lastIndex downTo 0) {
        if (plusDigit == 0) return digits
        plusDigit += digits[i]
        digits[i] = plusDigit % 10
        plusDigit /= 10
    }
    if (plusDigit == 0) return digits
    val result = IntArray(digits.size + 1)
    result[0] = 1
    for (i in digits.indices) {
        result[i + 1] = digits[i]
    }
    return result
}