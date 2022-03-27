package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var result = findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6))
    for (item in result) {
        println(item.joinToString())
    }
    result = findDifference(intArrayOf(1, 2, 3,3), intArrayOf(1,1,2,2))
    for (item in result) {
        println(item.joinToString())
    }

}

private fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {

    val list = mutableListOf<List<Int>>()
    list.add((nums1.toSet() subtract nums2.toSet()).toList())
    list.add((nums2.toSet() subtract nums1.toSet()).toList())

    return list
}