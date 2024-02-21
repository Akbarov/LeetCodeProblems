package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun numberOfWays(corridor: String): Int {
    val mod = 1_000_000_007
    val list = mutableListOf<Int>()
    for ((i, c) in corridor.withIndex()) {
        if (c == 'S') {
            list.add(i)
        }
    }
    if (list.isEmpty() || list.size % 2 == 1) return 0
    var result = 1
    var prev = list.first()
    for (i in 1 until list.size) {
        result = (result * (list[i] - prev)) % mod
        prev = list[i]
    }
    return result
}