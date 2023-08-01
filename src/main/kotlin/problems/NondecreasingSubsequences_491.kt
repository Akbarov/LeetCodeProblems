package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findSubsequences(intArrayOf(1, 2, 3, 4)))
}

private var result = mutableSetOf<List<Int>>()
private fun findSubsequences(nums: IntArray): List<List<Int>> {
    for (i in nums.indices) {
        dfs(nums, mutableListOf(nums[i]), i)
    }
    return result.toList()
}

private fun dfs(nums: IntArray, last: MutableList<Int>, index: Int) {
    if (index >= nums.size) return
    if (last.size >= 2) {
        val list = mutableListOf<Int>()
        list.addAll(last)
        result.add(list)
    }
    for (i in index + 1 until nums.size) {
        if (last[last.size - 1] <= nums[i]) {
            last.add(nums[i])
            dfs(nums, last, i)
            last.removeAt(last.size - 1)
        }
    }
}