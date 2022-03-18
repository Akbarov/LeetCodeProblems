package algorithm_II.day_9_recursion

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)).joinToString())

}

private fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.copyOf().shuffle()
    if (nums.isEmpty()) return emptyList()
    val subset = mutableListOf<MutableList<Int>>()
    val current = mutableListOf<Int>()
    generateSubset(0, nums.sorted(), current, subset)
    return subset
}

private fun generateSubset(
    index: Int,
    nums: List<Int>,
    current: MutableList<Int>,
    subset: MutableList<MutableList<Int>>
) {

    val list = mutableListOf<Int>()
    list.addAll(current.sorted())
    subset.add(list)


    for (i in index..nums.lastIndex) {
        if (i != index && nums[i] == nums[i - 1]) continue
        current.add(nums[i])
        generateSubset(i + 1, nums, current, subset)
        current.removeAt(current.size - 1)
    }

}