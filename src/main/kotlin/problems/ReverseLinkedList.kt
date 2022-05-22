package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val list = ListNode(1)
    list.next = ListNode(2)
    val third = ListNode(3)
    third.next = ListNode((4))
    list.next?.next = third
    var result = reverseList(list)
    while (result != null) {
        println(result.`val`)
        result = result.next
    }
}

private fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val temp = reverseList(head.next)
    head.next?.next = head
    head.next = null
    return temp
}