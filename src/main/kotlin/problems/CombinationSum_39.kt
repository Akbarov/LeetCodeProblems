package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var re = combinationSum(intArrayOf(2, 3, 6, 7), 7)
    for (arr in re) {
        println(arr.joinToString())
    }
    re = combinationSum(intArrayOf(2, 3, 5), 8)
    for (arr in re) {
        println(arr.joinToString())
    }

    re = combinationSum(intArrayOf(2), 1)
    for (arr in re) {
        println(arr.joinToString())
    }

}

private lateinit var result: MutableList<MutableList<Int>>
private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    result = mutableListOf()
    helper(candidates, target, mutableListOf(), 0)
    return result
}

private fun helper(candidates: IntArray, target: Int, tempList: MutableList<Int>, index: Int = 0) {
    if (tempList.sum() == target) {
        val temp = mutableListOf<Int>()
        temp.addAll(tempList)
        result.add(temp)
        return
    }
    if (tempList.sum() > target) {
        return
    }
    for (i in index..candidates.lastIndex) {
        tempList.add(candidates[i])
        helper(candidates, target, tempList, i)
        tempList.removeAt(tempList.lastIndex)
    }

}