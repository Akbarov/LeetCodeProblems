package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4, 4)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4, 2)))
}

// first solution
private fun containsDuplicate(nums: IntArray): Boolean {

    if (nums.size <= 1) return false
    val set = mutableSetOf<Int>()
    for (number in nums) {
        if (!set.add(number)) {
            return true
        }
    }
    return false
}

//second solution
private fun containsDuplicate2(nums: IntArray): Boolean {
    return nums.toSet().size != nums.size
}