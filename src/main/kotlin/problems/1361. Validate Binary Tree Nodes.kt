package problems

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1)))
}


private fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    val countList = IntArray(n)
    for (i in leftChild.indices) {
        if (leftChild[i] != -1) {
            countList[leftChild[i]]++
        }
        if (rightChild[i] != -1) {
            countList[rightChild[i]]++
        }
    }
    var root = -1
    for (i in 0 until n) {
        if (countList[i] == 0) {
            if (root == -1) {
                root = i
            } else return false
        }
    }
    if (root == -1) {
        return false
    }
    val queue: Queue<Int> = LinkedList()
    queue.add(root)
    val visited = BooleanArray(n)
    while (queue.isNotEmpty()) {
        val temp = queue.poll()
        if (visited[temp]) return false
        visited[temp] = true
        if (leftChild[temp] != -1) {
            queue.add(leftChild[temp])
        }
        if (rightChild[temp] != -1) {
            queue.add(rightChild[temp])
        }
    }
    var count = 0
    for (v in visited) {
        if (v) count++
    }
    return n == count
}
