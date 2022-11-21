package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    var result = mergeKLists(arrayOf(head, ListNode(4)))
    while (result != null) {
        println(result.`val`)
        result = result.next
    }
}

private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    if (lists.all { it == null }) return null
    val result = ListNode(-1)
    var temp: ListNode? = result
    var last: ListNode? = null
    var index = 0
    while (true) {
        for (i in lists.indices) {
            if (last == null) {
                last = lists[i]
                index = i
            } else {
                val t = lists[i]
                t?.apply {
                    if (last!!.`val` > `val`) {
                        last = lists[i]
                        index = i
                    }
                }
            }
        }
        if (last == null) break
        temp?.next = last
        temp = temp?.next
        lists[index] = lists[index]?.next
        last = null
    }
    return result.next
}