package algorithm_I

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "$`val` ${next.toString()}"
    }
}