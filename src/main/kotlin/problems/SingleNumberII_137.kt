package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)))
    println(singleNumber(intArrayOf(2, 2, 3, 2)))
}

private fun singleNumber(nums: IntArray): Int {
    val firstSet = HashSet<Int>()
    val secondSet = HashSet<Int>()

    for (item in nums) {
        if (item in firstSet) {
            firstSet.remove(item)
            if (item in secondSet) {
                secondSet.remove(item)
            } else {
                secondSet.add(item)
            }
        } else {
            if (item !in secondSet) {
                firstSet.add(item)
            }
        }
    }
    return firstSet.firstOrNull() ?: 0
}