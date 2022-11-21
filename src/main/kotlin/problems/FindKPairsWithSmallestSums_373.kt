package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val pq = PriorityQueue<Data> { p1, p2 -> p1.sum - p2.sum }
    val result = mutableListOf<List<Int>>()
    if (nums1.isEmpty() || nums2.isEmpty() || k == 0) return emptyList()
    var count = 0
    pq.add(Data(0, 0, nums1[0] + nums2[0]))
    while (pq.isNotEmpty() && count++ < k) {
        val data = pq.poll()
        result.add(listOf(nums1[data.i], nums2[data.j]))
        if (data.j < nums2.size - 1) {
            pq.add(Data(data.i, data.j + 1, nums1[data.i] + nums2[data.j + 1]))
        }
        if (data.j==0&&data.i < nums1.size-1) {
            pq.add(Data(data.i,0,nums1[data.i]+nums2[0]))
        }
    }
    return result
}

private data class Data(val i: Int, val j: Int, val sum: Int)