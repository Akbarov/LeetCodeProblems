package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(myPow(2.0, -2147483648))
}

private fun myPow(x: Double, n: Int): Double {
    if (x == 0.0) return 0.0
    if (x == 1.0) return 1.0
    if (n == 0) return 1.0
    return if (n < 0) {
        var result = 1.0
        val temp = -1*n
        repeat(temp) {
            result *= x
        }
        1 / result
    } else {
        var result = 1.0
        repeat(n) {
            result *= x
        }
        result
    }
}