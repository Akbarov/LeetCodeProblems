package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var head = GenerateListNode.generate(listOf(1, 2, 2, 2, 3, 4, 2))
    head = removeElements(head, 2)
    while (head != null) {
        println(head.`val`)
        head = head.next
    }
}

private fun removeElements(head: ListNode?, `val`: Int): ListNode? {

    var temp = head
    val result = ListNode(-1)
    var cur: ListNode? = result
    while (temp != null) {
        while (temp?.`val` == `val`) {
            temp = temp.next
        }
        cur?.next = temp
        cur = temp
        temp = temp?.next
    }
    return result.next
}
