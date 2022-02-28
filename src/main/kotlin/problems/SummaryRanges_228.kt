package problems

fun main() {
    println(summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)).joinToString())
    println(summaryRanges(intArrayOf(0, 2, 3, 4, 5, 7, 8)).joinToString())
}

private fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty()) return emptyList()
    var start = nums.first()
    val list = mutableListOf<String>()
    for (i in 0..nums.lastIndex) {
        if (i == nums.lastIndex || nums[i] + 1 != nums[i + 1]) {
            if (start == nums[i]) {
                list.add("$start")
            } else {
                list.add("$start->${nums[i]}")
            }
            if (i != nums.lastIndex) start = nums[i+1]
        }
    }

    return list
}