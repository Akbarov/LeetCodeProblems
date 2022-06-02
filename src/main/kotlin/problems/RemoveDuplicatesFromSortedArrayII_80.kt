package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    println(removeDuplicates2(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)))
}

private fun removeDuplicates(nums: IntArray): Int {
    var result = nums.size
    if (result <= 2) return result
    var i = 1
    while (i < result) {
        var c = i
        while (c < result && nums[c] == nums[i - 1]) {
            c++
        }
        val temp = c - i - 1
        if (temp > 0) {
            for (j in i + 1 until nums.size - temp) {
                nums[j] = nums[j + temp]
            }
            result -= temp
        }
        i++
    }
    println(nums.joinToString())
    return result
}
private fun removeDuplicates2(nums: IntArray):Int {
    var i=0
    for (item in nums) {
        if (i < 2 || item > nums[i - 2]) {
            nums[i++] = item
        }
    }
    return i
}