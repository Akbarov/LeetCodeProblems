package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {


    val head = GenerateListNode.generate(listOf(1, 2, 3, 4, 5))
    var temp = rotateRight(head, 6)
    while (temp != null) {
        println(temp.`val`)
        temp = temp.next
    }

}

private fun rotateRight(head: ListNode?, k: Int): ListNode? {

    if (head?.next == null || k == 0) return head

    var count = 1
    var temp = head
    while (temp?.next != null) {
        count++
        temp = temp.next
    }
    temp?.next = head
    val rotate = count - k % count
    if (rotate == 0) return head
    repeat(rotate) {
        temp = temp?.next
    }
    val result: ListNode? = temp?.next
    temp?.next = null
    return result

}