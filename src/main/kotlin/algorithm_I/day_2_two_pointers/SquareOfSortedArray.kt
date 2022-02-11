package algorithm_I.day_2_two_pointers

fun main() {
    println(sortedSquare(intArrayOf(-3, 1, 3, 5)))
}

private fun sortedSquare(nums: IntArray): IntArray {
    return nums.map { it * it }.sorted().toIntArray()
}

