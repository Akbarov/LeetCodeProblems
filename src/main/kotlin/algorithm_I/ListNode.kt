package algorithm_I

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "$`val` ${next.toString()}"
    }

    companion object {
        fun generateList(list: List<Int>): ListNode? {
            if (list.isEmpty()) return null
            val result = ListNode(0)
            var temp: ListNode? = result
            list.forEach {
                val t = ListNode(it)
                temp?.next = t
                temp = temp?.next
            }
            return result.next
        }
    }
}