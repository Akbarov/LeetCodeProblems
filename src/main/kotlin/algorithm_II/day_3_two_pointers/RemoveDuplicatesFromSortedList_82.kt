package algorithm_II.day_3_two_pointers

import algorithm_I.ListNode
import problems.GenerateListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val head = GenerateListNode.generate(listOf(1, 1, 2, 3, 3, 4, 4, 5))
    var temp = deleteDuplicates(head)
    while (temp != null) {
        println(temp.`val`)
        temp = temp.next
    }

}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var slow: ListNode? = ListNode(-1)
    slow?.next = head
    var temp: ListNode? = slow
    var fast = head

    while (fast != null) {
        if (fast.next != null && fast.`val` == fast.next?.`val`) {
            while (fast != null && fast.`val` == fast.next?.`val`) {
                fast = fast.next
            }
            temp?.next = fast?.next
        } else {
            temp = fast
        }
        fast = fast?.next
    }
    return slow?.next
}