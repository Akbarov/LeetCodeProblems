package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var result = combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8)
    for (arr in result) {
        println(arr.joinToString())
    }
    result = combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5)
    for (arr in result) {
        println(arr.joinToString())
    }

}

private lateinit var list: MutableList<List<Int>>

private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    if (candidates.isEmpty()) return emptyList()
    list = mutableListOf()
    candidates.sort()
    helper(candidates, target, mutableListOf(), 0)
    return list

}

private fun helper(candidates: IntArray, target: Int, currentList: MutableList<Int>, index: Int) {

    if (0 == target) {
        val temp = currentList.sorted()
        if (temp !in list) {
            list.add(temp)
        }
        return
    }
    if (0 > target) {
        return
    }

    for (i in index ..candidates.lastIndex) {
        if (candidates[i] > target) break
        if (i>index&&candidates[i-1]==candidates[i])continue
        currentList.add(candidates[i])
        helper(candidates, target - candidates[i], currentList, i+1)
        currentList.removeAt(currentList.lastIndex)
    }
}