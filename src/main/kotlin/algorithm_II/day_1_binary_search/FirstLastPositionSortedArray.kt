package algorithm_II.day_1_binary_search

fun main() {
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).joinToString())
    println(searchRange(intArrayOf(5, 7, 7, 8, 10), 6).joinToString())
}

private lateinit var resultArray: IntArray
private fun searchRange(nums: IntArray, target: Int): IntArray {
    resultArray = intArrayOf(-1, -1)
    if (nums.isEmpty()) return resultArray
    find(nums, target, 0, nums.lastIndex)
    return resultArray
}

private fun find(nums: IntArray, target: Int, l: Int, r: Int) {
    if (nums[l] > target) return
    if (nums[r] < target) return
    var mid = (l + r) / 2
    if (nums[l] == target && resultArray[0] == -1) {
        resultArray[0] = l
    }
    if (nums[r] == target) {
        resultArray[1] = r
    }
    if (r == l) return
    find(nums, target, l, mid)
    find(nums, target, mid + 1, r)

}