package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun swapPairs(head: ListNode?): ListNode? {

    if (head?.next == null) return head
    val result = head.next
    var temp = head
    result?.next = head

    return result

}