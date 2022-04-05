package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    var list = permute(intArrayOf(1, 2, 3))
//    for (row in list) {
//        println(row.joinToString())
//    }
    var list = permuteUnique(intArrayOf(1, 2,3))
    for (row in list) {
        println(row.joinToString())
    }
}

private lateinit var list: MutableList<MutableList<Int>>
private fun permuteUnique(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty()) return emptyList()
    list = mutableListOf()
    nums.sort()
    bfs(nums, mutableListOf(), BooleanArray(nums.size))
    return list
}

private fun bfs(nums: IntArray, curList: MutableList<Int>, isUsed: BooleanArray) {

    if (curList.size == nums.size) {
        val temp = mutableListOf<Int>()
        temp.addAll(curList)
        list.add(temp)
        return
    }
    for ((i, item) in nums.withIndex()) {
        if (isUsed[i]) continue
        if (i > 0 && nums[i - 1] == item && isUsed[i - 1]) continue
        curList.add(item)
        isUsed[i] = true
        bfs(nums, curList, isUsed)
        curList.removeAt(curList.lastIndex)
        isUsed[i] = false
    }
}