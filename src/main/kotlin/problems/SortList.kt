package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val middle = findMiddle(head)
    val left = sortList(head)
    val right = sortList(middle)
    return mergeList(left, right)
}

private fun mergeList(left: ListNode?, right: ListNode?): ListNode? {
    if (left == null) return right
    if (right == null) return left
    val head = ListNode(0)
    var temp: ListNode? = head
    var l = left
    var r = right
    while (l != null && r != null) {
        if (l.`val` < r.`val`) {
            temp?.next = l
            l = l.next
        } else {
            temp?.next = r
            r = r.next
        }
        temp = temp?.next
    }
    if (l != null) {
        temp?.next = l
        l = l.next
    }
    if (r != null) {
        temp?.next = r
        r = r.next
    }
    return head.next
}

private fun findMiddle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    var temp: ListNode? = null
    while (fast != null) {
        temp = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    temp?.next = null
    return slow
}