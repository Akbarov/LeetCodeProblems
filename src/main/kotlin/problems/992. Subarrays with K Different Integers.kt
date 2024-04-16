package problems

fun main() {
    println(subarraysWithKDistinct(intArrayOf(1, 2, 1, 2, 3), 2))
    println(subarraysWithKDistinct(intArrayOf(1, 2, 1, 3, 4), 3))
}

private fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    return countAtMostKDistinctElements(nums, k)- countAtMostKDistinctElements(nums,k-1)
}

private fun countAtMostKDistinctElements(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var left = 0
    var right = 0
    var result = 0
    while (right < nums.size) {
        map[nums[right]] = (map[nums[right]] ?: 0) + 1
        while (map.size > k && left < right) {
            if (map[nums[left]] == 1) map.remove(nums[left])
            else{
                map[nums[left]] = (map[nums[left]] ?: 0) - 1
            }
            left++
        }
        result+=(right-left+1)
        right++
    }
    return result
}