package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(swapNodes(ListNode(1), 1))
}

private fun swapNodes(head: ListNode?, k: Int): ListNode? {

    var firstK: ListNode? = null
    var lastK: ListNode? = null
    var counter = 1
    var t = head
    while (counter++ < k) {
        t = t?.next
    }
    firstK = t
    lastK = head
    while (t?.next != null) {
        t = t.next
        lastK = lastK?.next
    }
    val ts = lastK?.`val`
    lastK?.`val` = firstK?.`val` ?: 0
    firstK?.`val` = ts ?: 0

    return head
}