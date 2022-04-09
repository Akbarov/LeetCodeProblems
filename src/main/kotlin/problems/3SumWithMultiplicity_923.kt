package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(threeSumMulti(intArrayOf(1,1,2,2,3,3,4,4,5,5),8))
    println(threeSumMulti(intArrayOf(1,1,2,2,2,2),5))
}

private var count = 0
private fun threeSumMulti(arr: IntArray, target: Int): Int {
    count = 0
    helper(arr, target, mutableListOf(), 0)
    return count
}

private fun helper(arr: IntArray, target: Int, curr: MutableList<Int>, index: Int) {
    if (curr.size > 3) return
    if (curr.size == 3 && curr.sum() == target) {
        count++
        return
    }
    for (i in index..arr.lastIndex) {
        curr.add(arr[i])
        helper(arr, target, curr, i+1)
        curr.removeAt(curr.lastIndex)
    }
}