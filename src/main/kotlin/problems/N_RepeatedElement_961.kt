package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun repeatedNTimes(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (item in nums) {
        map[item] = (map[item] ?: 0) + 1
        if (map[item] == nums.size / 2)
            return item
    }
    return -1
}