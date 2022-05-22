package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    val result = ListNode(0)
    var temp: ListNode? = result
    var l1 = list1
    var l2 = list2
    while (l1 != null || l2 != null) {
        if (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                temp?.next = l1
                l1 = l1.next
            } else {
                temp?.next = l2
                l2 = l2.next
            }
        } else if (l1 != null) {
            temp?.next = l1
            l1 = l1.next
        } else {
            temp?.next = l2
            l2 = l2?.next
        }
        temp = temp?.next
    }
    return result.next

}