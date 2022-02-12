package algorithm_I.day_3_two_pointers

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString())
    println(twoSum(intArrayOf(-1, 0), -1).joinToString())
    println(twoSum2(intArrayOf(2, 7, 11, 15), 9).joinToString())
    println(twoSum2(intArrayOf(-1, 0), -1).joinToString())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    for ((index, item) in nums.withIndex()) {
        for (j in index + 1..nums.lastIndex) {
            if (item + nums[j] == target) {
                return intArrayOf(index + 1, j + 1)
            }
        }
    }
    return intArrayOf()
}

private fun twoSum2(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.lastIndex
    var sum: Int
    while (start < end) {
        sum = numbers[start] + numbers[end]
        if (sum == target) return intArrayOf(start + 1, end + 1)
        else if (sum > target) end--
        else start++
    }
    return intArrayOf()
}