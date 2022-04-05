package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var head = GenerateListNode.generate(listOf(4, 5, 1, 9))
    deleteNode2(head?.next)
    while (head != null) {
        println(head.`val`)
        head = head.next
    }

}

private fun deleteNode(node: ListNode?) {
    var temp = node
    while (temp?.next?.next != null) {
        temp.`val` = temp.next?.`val` ?: 0
        temp = temp.next
    }
    temp?.`val` = temp?.next?.`val` ?: 0
    temp?.next = null
}

private fun deleteNode2(node: ListNode?) {
    node?.`val` = node?.next?.`val` ?: 0
    node?.next = node?.next?.next
}