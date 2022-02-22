package algorithm_I.day_13

fun main() {
    println(isPowerOfTwo2(1_073_741_825))
    println(isPowerOfTwo2(1))
    println(isPowerOfTwo2(8))
    println(isPowerOfTwo2(0))
}

private fun isPowerOfTwo(n: Int): Boolean {
    var power = n
    while (power > 1 && power % 2 == 0) {
        power /= 2
    }
    return power == 1
}

private fun isPowerOfTwo2(n: Int): Boolean {
    return !(n == 0 || n.and(n - 1) != 0)
}