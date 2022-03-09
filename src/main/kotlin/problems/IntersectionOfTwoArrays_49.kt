package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString())
    println(intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).joinToString())
}

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (n in nums2) {
        map[n] = 0
    }
    for (n in nums1) {
        if (map[n] != null) {
            map[n] = 1
        }
    }
    return map.filter { it.value == 1 }.keys.toIntArray()

}

private fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    return (nums1.toSet() intersect  nums2.toSet()).toIntArray()
}
