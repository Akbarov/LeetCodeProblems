package problems

import algorithm_I.TreeNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

class BSTIterator(root: TreeNode?) {

    var queue: Queue<Int> = LinkedList()

    init {
        inorder(root)
    }

    private fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        queue.offer(root.`val`)
        inorder(root.right)
    }

    fun next(): Int {
        return queue.poll()
    }

    fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }

}

class BSTIterator2(root: TreeNode?) {

    var stack = Stack<TreeNode>()
    var temp: TreeNode? = null

    init {
        temp = root
        leftRoot()
    }

    private fun leftRoot() {
        while (temp != null) {
            stack.push(temp)
            temp = temp?.left
        }
    }

    fun next(): Int {
        temp = stack.pop()
        leftRoot()
        return temp?.`val` ?: 0
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

}