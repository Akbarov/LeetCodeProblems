package algorithm_II.day_3_two_pointers

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var slow: ListNode? = null
    var temp: ListNode? = null
    var fast = head
    while (fast != null) {
        while (fast != null && fast.`val` == fast.next?.`val`) {
            fast = fast.next
        }
        if (slow == null) {
            slow = fast
            temp = fast
        } else {
            temp?.next = fast
        }
    }
    return slow
}