package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
    var count = 0
    var temp = head
    while (temp != null) {
        count++
        temp = temp.next
    }
    temp = head
    val result = Array<ListNode?>(k) { null }
    var remain = count % k
    count /= k
    for (i in result.indices) {
        val currentHead: ListNode? = temp
        var j = 0
        while (j < count && temp != null) {
            j++
            temp = temp.next
        }
        if (remain > 0) {
            temp = temp?.next
            remain--
        }

        val t: ListNode? = temp?.next
        temp?.next = null
        temp = t
        result[i] = currentHead
    }

    return result
}
