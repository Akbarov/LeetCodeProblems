package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    nextPermutation(intArrayOf(1, 2, 3))
    nextPermutation(intArrayOf(1, 1, 5))
    nextPermutation(intArrayOf( 3, 2,1))
}

private fun nextPermutation(nums: IntArray) {

    var i = nums.size - 2
    while (i >= 0 && nums[i + 1] < nums[i]) {
        i--
    }
    if (i > 0) {
        var j = nums.lastIndex
        while (nums[j] <= nums[i]) {
            j--
        }
        swap(nums, i, j)
    }
    reverse(nums, i+1)
    println(nums.joinToString())

}

private fun reverse(nums: IntArray, start: Int) {
    var l = start
    var r = nums.lastIndex
    while (l < r) {
        swap(nums, l, r)
        l++
        r--
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}