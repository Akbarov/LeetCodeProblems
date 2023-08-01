package problems

import algorithm_I.ListNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var result = reverseKGroup(ListNode.generateList(listOf(1, 2, 3, 4, 5)), 2)
    while (result != null) {
        println(result.`val`)
        result = result.next
    }
}

private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null || k == 1) return head
    val result = ListNode(0)
    var temp: ListNode? = head
    val stack = Stack<ListNode>()
    var last: ListNode? = null
    var count = 0
    while (temp != null) {
        stack.add(temp)
        val next = temp.next
        count++
        if (count == k) {
            while (stack.isNotEmpty()) {
                val current = stack.pop()
                if (result.next == null) {
                    result.next = current
                } else {
                    last?.next = current
                }
                last = current
                current?.next = if (stack.isEmpty()) next else stack.peek()
            }
            count = 0
        }
        println(next?.`val`)
        temp = next
    }
    return result.next
}