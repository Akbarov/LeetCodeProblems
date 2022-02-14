package algorithm_I.day_5_two_pointers

import algorithm_I.ListNode


fun main() {
    val first = ListNode(0)
    val second = ListNode(1)
    val third = ListNode(2)
    second.next = third
    first.next = second
    println(removeNthNodeFromEnd(first,1)?.toString())
    println(removeNthNodeFromEnd(first,2)?.toString())
}

private fun removeNthNodeFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var start = head
    var count = 0
    while (start != null) {
        count++
        start = start.next
    }
    start = head
    while (start != null) {
        if (count-- == n) {
            start = start.next?.next
            break
        }
        start = start.next
    }
    return head
}