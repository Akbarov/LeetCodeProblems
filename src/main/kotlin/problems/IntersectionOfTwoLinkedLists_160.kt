package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

    var slowA = headA
    var fastB: ListNode?
    while (slowA != null) {
        fastB = headB
        while (fastB != null) {
            if (slowA == fastB) {
                return fastB
            } else {
                fastB = fastB.next
            }
        }
        slowA = slowA.next
    }
    return null

}

private fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {
    var lengthA = 0
    var lengthB = 0
    var slowA = headA
    var slowB = headB
    while (slowA != null) {
        lengthA++
        slowA = slowA.next
    }
    while (slowB != null) {
        lengthB++
        slowB = slowB.next
    }
    slowA = headA
    slowB = headB
    if (lengthA > lengthB) {
        repeat(lengthA - lengthB) {
            slowA = slowA?.next
        }
    } else {
        repeat(lengthB - lengthA) {
            slowB = slowB?.next
        }
    }
    while (slowB != null && slowA != null) {
        if (slowA == slowB) {
            return slowB
        }
        slowB = slowB?.next
        slowA = slowA?.next
    }
    return null
}
