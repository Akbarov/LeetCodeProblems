package algorithm_I.day_5_two_pointers

import algorithm_I.ListNode


fun main() {
    val first = ListNode(0)
    val second = ListNode(1)
    val third = ListNode(2)
    second.next = third
    first.next = second
    println(middleNode(first))
    println(middleNode2(first))

}

private fun middleNode(head: ListNode?): ListNode? {
    if (head == null) return null
    var start: ListNode? = ListNode(head.`val`)
    start?.next = head.next
    var count = 0
    while (start != null) {
        count++
        start = start.next
    }
    var middle = 1
    start = head
    while (start?.next != null && middle <= count / 2) {
        middle++
        start = start.next
    }
    return start
}

private fun middleNode2(head: ListNode?): ListNode? {
    if (head == null) return null
    var slow = head
    var fast = head
    while (slow != null && fast?.next != null) {
        slow = slow.next
        fast = fast.next?.next
    }
    return slow
}