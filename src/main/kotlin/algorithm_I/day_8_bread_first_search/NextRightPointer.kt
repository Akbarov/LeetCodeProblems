package algorithm_I.day_8_bread_first_search

import algorithm_I.Node


fun main() {

}

private fun connect(root: Node?): Node? {
    if (root?.left == null || root.right == null) return root
             root.left?.next = root.right
    if (root.next != null) {
        root.right?.next = root.next?.left
    }
    connect(root.left)
    connect(root.right)
    return root
}