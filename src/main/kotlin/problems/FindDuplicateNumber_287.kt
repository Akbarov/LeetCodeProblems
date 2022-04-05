package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
}

private fun findDuplicate(nums: IntArray): Int {

    if (nums.isEmpty()) return -1
    val isVisited = BooleanArray(nums.size)
    for (item in nums) {
        if (isVisited[item - 1]) return item
        isVisited[item - 1] = true
    }
    return -1
}