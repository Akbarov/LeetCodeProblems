package problems

import algorithm_I.ListNode
import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(isPalindrome(GenerateListNode.generate(listOf(0, 0))))
    println(isPalindrome(GenerateListNode.generate(listOf(1))))
}

private fun isPalindrome(head: ListNode?): Boolean {
    var temp = head
    var count = 0
    val stack = Stack<Int>()
    while (temp != null) {
        temp = temp.next
        count++
    }
    temp = head
    var index = 1
    while (temp != null) {
        when {
            index * 2 - 1 == count -> {}
            index <= count / 2 -> {
                stack.push(temp.`val`)
            }
            else -> {
                if (stack.isNotEmpty() && stack.pop() != temp.`val`) {
                    return false
                }
            }
        }
        index++
        temp = temp.next
    }
    return true
}
