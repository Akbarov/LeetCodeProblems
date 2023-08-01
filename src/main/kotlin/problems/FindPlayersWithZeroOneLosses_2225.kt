package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(findWinners(arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,3))))
}

private fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val lostUsers = mutableMapOf<Int, Int>()
    matches.forEach {
        lostUsers[it[1]] = (lostUsers[it[1]] ?: 0) + 1
    }
    val winnerList = mutableSetOf<Int>()
    for (match in matches) {
        if (match[0] !in lostUsers.keys) {
            winnerList.add(match[0])
        }
    }
    val oneLostUser = lostUsers.filter { it.value == 1 }.keys.toList()
    return listOf(winnerList.sorted(), oneLostUser.sorted())
}