package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(climbStairs(3))
    println(climbStairs(5))
    println(climbStairs(6))
    println(climbStairs(8))
}

private fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    var f = 1
    var s = 2
    var c = n - 2
    while (c-- > 0) {
        val temp = s
        s += f
        f = temp
    }
    return s
}