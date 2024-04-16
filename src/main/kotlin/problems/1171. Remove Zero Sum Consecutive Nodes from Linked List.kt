package problems

import algorithm_I.ListNode

fun main() {

}

private fun removeZeroSumSublists2(head: ListNode?): ListNode? {
    val result = ListNode(0)
    result.next = head
    var temp = head
    val map = mutableMapOf<Int, ListNode?>()
    var sum = 0
    map[0] = head
    while (temp != null) {
        sum += temp.`val`
        if (map[sum] != null) {
            var toDelete = map[sum]?.next
            var tempSum = sum + (toDelete?.`val` ?: 0)
            while (toDelete != temp) {
                map.remove(tempSum)
                toDelete = toDelete?.next
                tempSum += (toDelete?.`val` ?: 0)
            }
            map[sum]?.next = temp.next
        } else {
            map[sum] = temp
        }
        temp = temp.next
    }
    return result.next
}

private fun removeZeroSumSublists(head: ListNode?): ListNode? {
    if (head == null) return null
    val list = convertToList(head)
    for (i in list.indices) {
        var sum = 0
        for (j in i downTo 0) {
            if (list[j] == Int.MAX_VALUE) continue
            sum += list[j]
            if (sum == 0) {
                for (k in j..i) {
                    list[k] = Int.MAX_VALUE
                }
            }
        }
    }

    return convertToNode(list)
}

private fun convertToNode(list: MutableList<Int>): ListNode? {
    val result = ListNode(0)
    var temp: ListNode? = result
    for (item in list) {
        if (item != Int.MAX_VALUE) {
            val node = ListNode(item)
            temp?.next = node
            temp = temp?.next
        }
    }
    return result.next
}

private fun convertToList(head: ListNode?): MutableList<Int> {
    val result = mutableListOf<Int>()
    var temp = head
    while (temp != null) {
        result.add(temp.`val`)
        temp = temp.next
    }
    return result
}