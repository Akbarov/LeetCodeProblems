package algorithm_I.day_10_recursion

import algorithm_I.ListNode
import java.util.Stack

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val first = ListNode(4)
    val second = ListNode(5)
    val third = ListNode(6)
    second.next = third
    first.next = second
    val result = reverseList2(first)
    println(result.toString())
}


private fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val stack = Stack<ListNode>()
    var start = head

    while (start != null) {
        stack.push(start)
        start = start.next
    }
    start = stack.pop()
    val result = start
    while (stack.isNotEmpty()) {
        start?.next = stack.pop()
        start = start?.next
    }
    start?.next = null
    return result
}

private fun reverseList2(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var prev: ListNode? = null
    var current = head
    var next: ListNode? = null
    while (current != null) {
        next = prev
        prev = current
        current = current.next
        prev.next = next
    }
    return prev
}