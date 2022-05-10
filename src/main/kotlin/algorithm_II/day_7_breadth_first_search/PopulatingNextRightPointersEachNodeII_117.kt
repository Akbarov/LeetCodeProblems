package algorithm_II.day_7_breadth_first_search

import problems.Node

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun connect(root: Node?): Node? {
    if (root?.left == null || root.right == null) return root
    root.left?.next = if (root.right != null) root.right else {
        if (root.next?.left != null) root.next?.left
        else root.next?.right
    }
    if (root.next != null) {
        root.right?.next = if (root.next?.left != null) root.next?.left else root.next?.right
    }
    connect(root.left)
    connect(root.right)
    return root

}