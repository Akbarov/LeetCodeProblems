package algorithm_II.day_3_two_pointers

fun main() {
//    threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).forEach { println(it.joinToString()) }
    threeSum(intArrayOf(-1, 0, 1, 0)).forEach { println(it.joinToString()) }
}

private fun threeSum(nums: IntArray): List<List<Int>> {

    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0..nums.lastIndex - 2) {
        if (i > 0 && nums[i - 1] == nums[i]) {
            continue
        }
        var left = i + 1
        var right = nums.lastIndex
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            if (sum == 0) {
                result.add(listOf(nums[i], nums[left], nums[right]))
                right--
                while (left < right && nums[right+1] == nums[right]) right--
            }
            while (left < right && nums[left] == nums[right]) right--
            if (sum > 0) right--
            else left++
        }
    }
    return result

}