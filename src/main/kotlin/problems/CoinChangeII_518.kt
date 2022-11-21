package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(change(5, intArrayOf(1, 2, 5)))
}

private var result = 0
private fun change(amount: Int, coins: IntArray): Int {
    helper(amount, coins, 0)
    return result
}

private fun helper(amount: Int, coins: IntArray, index: Int) {
    if (amount == 0) {
        result++
        return
    }
    if (amount < 0) {
        return
    }
    for (i in index until coins.size) {
        helper(amount - coins[i], coins, i)
    }
}