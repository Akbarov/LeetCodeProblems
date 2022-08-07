package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(numJewelsInStones("ab","abdrdB"))
}

private fun numJewelsInStones(jewels: String, stones: String): Int {
    val set = jewels.toHashSet()
    return stones.count { it in set }
}