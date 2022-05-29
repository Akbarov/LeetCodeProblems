package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
}

private fun longestConsecutive(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    for (item in nums) {
        set.add(item)
    }
    var count = 1
    var maxCount = 1
    for (item in set) {
        if (!set.contains(item - 1)) {
            var temp = item
            while (set.contains(++temp)) {
                count++
            }
            if (maxCount < count) {
                maxCount = count
                count = 1
            }
        }
    }
    return maxCount
}