package problems

fun main() {

}

private var head: CalendarTreeNode? = null
private fun book(start: Int, end: Int): Boolean {
    if (head == null) {
        head = CalendarTreeNode(start, end)
        return true
    }
    return insertTree(root = head, start, end)
}

private fun insertTree(root: CalendarTreeNode?, start: Int, end: Int): Boolean {
    if (root == null) return false
    if (end <= root.start) {
        if (root.left == null) {
            root.left = CalendarTreeNode(start, end)
            return true
        } else return insertTree(root.left, start, end)
    } else if (start >= root.end) {
        if (root.right == null) {
            root.right = CalendarTreeNode(start, end)
            return true
        } else return insertTree(root.right, start, end)
    } else return false
}

private class CalendarTreeNode(val start: Int, val end: Int) {
    var left: CalendarTreeNode? = null
    var right: CalendarTreeNode? = null
}