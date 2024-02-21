package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(checkArithmeticSubarrays(intArrayOf(3, 2, 4, 6), intArrayOf(0, 1), intArrayOf(2, 3)).joinToString())
}

private fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    val list = MutableList(l.size) { false }
    for (i in l.indices) {
        if (r[i] - l[i] > 1) {
            list[i] = isArithmetic(nums.copyOfRange(l[i], r[i]))
        }
    }
    return list
}

private fun isArithmetic(nums: IntArray): Boolean {
    nums.sort()
    val dif = nums[1] - nums[0]
    for (i in 1 until nums.size) {
        if (nums[i] - nums[i - 1] != dif) return false
    }
    return true
}