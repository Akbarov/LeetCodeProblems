package problems

import algorithm_I.ListNode

fun main() {

}

private fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    var secondLast = list2
    while (secondLast?.next != null) {
        secondLast = secondLast.next
    }
    val dammy = ListNode(0)
    dammy.next = list1
    var temp: ListNode? = dammy
    var count = 0
    var removeStart: ListNode? = null
    while (temp != null && count++ != a) {
        removeStart = temp.next
        temp.next = list2
        temp = temp.next
    }
    while (removeStart != null && count++ != b) {
        secondLast?.next = removeStart.next
        removeStart = removeStart.next
    }
    return dammy.next
}