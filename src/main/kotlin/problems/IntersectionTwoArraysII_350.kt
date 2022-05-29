package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString())
}

private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var l = 0
    var r = 0
    nums1.sort()
    nums2.sort()
    while (l < nums1.size && r < nums2.size) {
        if (nums1[l] == nums2[r]) {
            result.add(nums1[l])
            l++
            r++
        } else if (nums1[l] < nums2[r]) l++
        else r++
    }
    return result.toIntArray()
}