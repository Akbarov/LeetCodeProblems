package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(arrangeCoins(1))
    println(arrangeCoins(5))
    println(arrangeCoins(8))
}

private fun arrangeCoins(n: Int): Int {
    return ((Math.sqrt(8 * n.toDouble() + 1) - 1) / 2).toInt()
}