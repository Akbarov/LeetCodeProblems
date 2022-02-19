package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var first = m-1
    var second = n-1
    for (i in nums1.lastIndex downTo 0) {
        if (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[i] = nums1[first--]
            } else {
                nums1[i] = nums2[second--]
            }
        } else if (second >= 0) {
            nums1[i] = nums2[second--]
        } else {
            break
        }
    }
    println(nums1.joinToString())
}