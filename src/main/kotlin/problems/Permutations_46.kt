package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var list = permute(intArrayOf(1, 2, 3))
    for (row in list) {
        println(row.joinToString())
    }
    list = permute(intArrayOf(0,1))
    for (row in list) {
        println(row.joinToString())
    }
}

private lateinit var list: MutableList<MutableList<Int>>
private fun permute(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty()) return emptyList()
    list = mutableListOf()
    bfs(nums, mutableListOf())
    return list
}

private fun bfs(nums: IntArray, curList: MutableList<Int>) {

    if (curList.size == nums.size) {
        val temp = mutableListOf<Int>()
        temp.addAll(curList)
        list.add(temp)
        return
    }
    for (item in nums) {
        if (item !in curList) {
            curList.add(item)
            bfs(nums, curList)
            curList.removeAt(curList.lastIndex)
        }
    }

}