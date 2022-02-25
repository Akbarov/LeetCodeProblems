package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun hasCycle2(head: ListNode?): Boolean {
    if (head==null)return false
    val set = mutableSetOf<ListNode>()
    var start = head
    while (start != null) {
        if (set.contains(start))return true
        set.add(start)
        start = start.next
    }
    return false
}

private fun hasCycle(head: ListNode?): Boolean {
    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (slow == fast) return true
    }
    return false

}