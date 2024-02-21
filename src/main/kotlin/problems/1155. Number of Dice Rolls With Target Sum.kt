package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private val memo = mutableMapOf<String, Int>()
private val mode = 1_000_000_007
private fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    if (n == 0 && target == 0) return 1
    if (n == 0 || target == 0) return 0
    val key = "$n:$target"
    memo[key]?.apply {
        return this
    }
    var result = 0
    for (i in 1..k) {
        if (target >= i) {
            result = (result % mode + numRollsToTarget(n - 1, k, target - i) % mode) % mode
        }
    }
    memo[key] = result
    return result
}