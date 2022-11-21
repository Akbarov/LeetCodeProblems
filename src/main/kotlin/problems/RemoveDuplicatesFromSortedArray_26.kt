package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(removeDuplicates(intArrayOf(1,1,2)))
}

private fun removeDuplicates(nums: IntArray): Int {
    var result = 0
    var i = 1
    while (i < nums.size - result) {
        if (nums[i] == nums[i - 1]) {
            result++
            for (j in i until nums.size - 1) {
                val t = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = t
            }
        } else i++
    }
    println(nums.joinToString())
    return result
}