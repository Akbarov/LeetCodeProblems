package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maximizeGreatness(nums: IntArray): Int {

    nums.sort()
    var result = 0
    for (item in nums) {
        if (item > nums[result]) {
            result++
        }
    }
    return result

}