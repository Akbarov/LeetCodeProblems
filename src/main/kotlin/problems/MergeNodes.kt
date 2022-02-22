package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun mergeNodes(head: ListNode?): ListNode? {
    var start = head
    if (start?.next == null) return head
    var result: ListNode? = head?.next
    var temp: ListNode? = head?.next
    var sum = 0
    while (start?.next != null) {
        if (start?.next?.`val` != 0) {
            start?.`val` = sum
            if (result == null) {
                result = start
                temp = result
            } else {
                result.next = start
            }
        }
        sum += start?.`val`?:0
        start = start?.next
    }
    return temp
}