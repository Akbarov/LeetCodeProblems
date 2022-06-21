package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var head: ListNode? = ListNode(4)
    head?.next = ListNode(3)
    head?.next?.next = ListNode(0)
    head = insertionSortList(head)
    println(head)
}

private fun insertionSortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var temp = head
    var next: ListNode?
    val fakeHead = ListNode(0)
    while (temp != null) {
        next = temp.next
        var k: ListNode? = fakeHead
        while (k?.next != null && (k.next?.`val` ?: Int.MAX_VALUE) < temp.`val`) {
            k = k.next
        }
        temp.next = k?.next
        k?.next = temp
        temp = next
    }

    return fakeHead.next
}