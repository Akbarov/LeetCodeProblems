package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun partition(head: ListNode?, x: Int): ListNode? {

    if (head?.next == null) return head
    val less = ListNode(0)
    var l = less
    val greater = ListNode(0)
    var g = greater
    var tempHead = head
    while (tempHead != null) {
        if (tempHead.`val` < x) {
            l.next = tempHead
            l = tempHead
        } else {
            g.next = tempHead
            g = tempHead
        }
        tempHead = tempHead.next
    }
    g.next = null
    l.next = greater.next
    return less.next

}