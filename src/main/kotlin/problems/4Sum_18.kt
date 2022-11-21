package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(fourSum2(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    println(fourSum2(intArrayOf(2, 2, 2, 2, 2), 8))
}

private val result = mutableListOf<MutableList<Int>>()
private val tempList = mutableListOf<Int>()
private fun fourSum2(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()
    kSum(nums, target.toLong(), 0, 4)
    return result
}

private fun kSum(nums: IntArray, target: Long, start: Int, k: Int) {
    if (k != 2) {
        for (i in start..nums.size - k) {
            if (i > start && nums[start] == nums[i]) continue
            tempList.add(nums[i])
            kSum(nums, target - nums[i], i + 1, k - 1)
            tempList.removeAt(tempList.size - 1)
        }
    } else {
        var left = start
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum > target) {
                right--
            } else if (sum < target) {
                left++
            } else {
                val t = mutableListOf<Int>()
                t.addAll(tempList)
                t.add(nums[left])
                t.add(nums[right])
                result.add(t)
                left++
                while (left < right && nums[left - 1] == nums[left]) left++
            }
        }
    }
}


private val resultList = mutableSetOf<List<Int>>()
private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    helper(nums, target, mutableListOf(), 0)
    return resultList.toList()
}

private fun helper(nums: IntArray, target: Int, currentList: MutableList<Int>, index: Int) {
    if (currentList.size == 4) {
        if (currentList.sum() == target) {
            resultList.add(currentList.sorted())
        }
        return
    }
    if (index > nums.size) return
    for (i in index until nums.size) {
        currentList.add(nums[i])
        helper(nums, target, currentList, i + 1)
        currentList.removeAt(currentList.lastIndex)
    }
}