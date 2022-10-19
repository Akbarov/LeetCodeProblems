package problems

import algorithm_I.ListNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun reorderList(head: ListNode?): Unit {
    if (head == null) return
    val stack = Stack<ListNode>()
    var count = 0
    var temp = head
    while (temp != null) {
        count++
        stack.add(temp)
        temp = temp.next
    }
    temp = head
    while (count >= 0 && temp != null) {
        val pop = stack.pop()
        val next = temp.next
        temp.next = pop
        pop.next = next
        temp = next
        count -= 2
    }
}