package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var start = head

    while (start?.next != null) {
        if (start.`val` == start.next?.`val`) {
            start.next = start.next?.next
        }else{
            start = start.next
        }
    }

    return head
}