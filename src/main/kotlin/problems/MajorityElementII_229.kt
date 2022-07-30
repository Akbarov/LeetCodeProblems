package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(majorityElement(intArrayOf(2, 1, 2)))
    println(majorityElement(intArrayOf(2, 1)))
}

private fun majorityElement(nums: IntArray): List<Int> {
    if (nums.size < 3) return nums.toSet().toList()
    nums.sort()
    var fast = 0
    var slow = 0
    val elements = mutableSetOf<Int>()
    while (fast < nums.size) {
        if (nums[fast] != nums[slow]) {
            if (fast - slow > nums.size / 3) elements.add(nums[slow])
            slow = fast
        }
        fast++
    }
    if (fast - slow > nums.size / 3) elements.add(nums[slow])
    return elements.toList()

}