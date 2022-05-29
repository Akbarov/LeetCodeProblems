package problems

import algorithm_I.ListNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) return null
    val set = HashSet<ListNode>()
    var temp = head
    while (temp != null) {
        if (!set.add(temp)) {
            break
        }
        temp = temp.next
    }
    return temp
}