package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
object GenerateListNode {
    fun generate(list: List<Int>?): ListNode? {
        if (list.isNullOrEmpty()) return null
        val head: ListNode = ListNode(list.first())
        var temp: ListNode? = head
        for (i in 1..list.lastIndex) {
            temp?.next = ListNode(list[i])
            temp = temp?.next
        }
        return head
    }
}