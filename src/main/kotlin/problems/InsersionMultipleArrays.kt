package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(intersection(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6)
    )).joinToString())
}

private fun intersection(nums: Array<IntArray>): List<Int> {
    var result = nums[0].toSet()
    for (i in 1..nums.lastIndex) {
        result = result intersect nums[i].toSet()
    }
    return result.sorted()
}