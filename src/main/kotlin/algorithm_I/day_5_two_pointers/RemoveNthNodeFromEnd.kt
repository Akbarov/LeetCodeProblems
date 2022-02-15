package algorithm_I.day_5_two_pointers

import algorithm_I.ListNode


fun main() {
    val first = ListNode(0)
    val second = ListNode(1)
    val third = ListNode(2)
    second.next = third
    first.next = second
//    println(removeNthNodeFromEnd(first, 1)?.toString())
    println(removeNthNodeFromEnd2(first, 2)?.toString())
}

private fun removeNthNodeFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var fast = head
    var slow = head
    var counter = 0
    while (n > counter++) {
        fast = fast?.next
    }
    if (fast == null) return head.next
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next
    }
    slow?.next = slow?.next?.next
    return head
}

private fun removeNthNodeFromEnd2(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) {
        return null
    }
    var total = 0
    var f = head
    while (f != null) {
        f = f.next
        total++
    }
    if (total == n) {
        return head.next
    }
    total -= n
    var prev = head
    while (total > 1) {
        prev = prev?.next
        total--
    }
    prev?.next = prev?.next?.next
    return head
}