package algorithm_II.day_9_recursion

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(subsets(intArrayOf(1,2,3)).joinToString())

}

private fun subsets(nums: IntArray): List<List<Int>> {
    val subset = mutableListOf<MutableList<Int>>()
    generateSubset(0, nums, mutableListOf(), subset)
    return subset
}

private fun generateSubset(
    index: Int,
    nums: IntArray,
    current: MutableList<Int>,
    subset: MutableList<MutableList<Int>>
) {
    val list = mutableListOf<Int>()
    list.addAll(current)
    subset.add(list)
    for (i in index..nums.lastIndex) {
        current.add(nums[i])
        generateSubset(i + 1, nums, current, subset)
        current.removeAt(current.size - 1)
    }

}