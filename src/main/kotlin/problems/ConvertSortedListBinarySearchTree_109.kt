package problems

import algorithm_I.ListNode
import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */

/**
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 */

fun main() {
    val head = ListNode(-10)
    head.next = ListNode(-3)
    head.next?.next = ListNode(0)
    head.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next = ListNode(9)
    val treeNode = sortedListToBST(head)
    println(treeNode?.`val`)
    println(treeNode?.left?.`val`)
    println(treeNode?.right?.`val`)
}

private fun sortedListToBST(head: ListNode?): TreeNode? {
    return helper(head, null)
}

private fun helper(head: ListNode?, tail: ListNode?): TreeNode? {
    if (head == tail) return null
    val mid = getMidNode(head, tail) ?: return null
    val treeNode = TreeNode(mid.`val`)
    treeNode.left = helper(head, mid)
    treeNode.right = helper(mid.next, tail)
    return treeNode
}

private fun getMidNode(head: ListNode?, tail: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast != null && slow != null && fast != tail) {
        if (fast.next == tail) return slow
        fast = fast.next?.next
        slow = slow.next
    }
    return slow
}