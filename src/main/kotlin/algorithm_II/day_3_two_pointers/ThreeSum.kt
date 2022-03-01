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
        var j = i + 1
        var k = nums.lastIndex
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) {
                result.add(listOf(nums[i], nums[j], nums[k]))
                k--
                while (j < k && nums[k+1] == nums[k]) k--
            }
            while (j < k && nums[j] == nums[k]) k--
            if (sum > 0) k--
            else j++
        }
    }
    return result

}