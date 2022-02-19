package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(mySqrt(10))
println(mySqrt(2147395600))
}

private fun mySqrt(x: Int): Int {
    if (x <= 1) return x
    var c = 1L
    while (c * c <= x) {
        c++
    }
    return c.toInt() - 1
}