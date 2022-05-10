package problems

import algorithm_I.TreeNode
import java.util.Stack

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(find132pattern(intArrayOf(1, 2, 3, 4)))
    println(find132pattern(intArrayOf(3, 1, 4, 2)))
    println(find132pattern2(intArrayOf(-1, 3, 2, 0)))
}
// time complexity O(n^3)
private fun find132pattern(nums: IntArray): Boolean {
    for (i in 0..nums.lastIndex) {
        for (j in i + 1..nums.lastIndex) {
            for (k in j + 1..nums.lastIndex) {
                if (nums[i] < nums[k] && nums[k] < nums[j]) {
                    return true
                }
            }
        }
    }
    return false
}
private fun find132pattern2(nums: IntArray):Boolean{
    var third = Int.MIN_VALUE
    val stack = Stack<Int>()
    for (i in nums.lastIndex downTo 0) {
        if (nums[i]<third)return true
        while (stack.isNotEmpty()&&stack.peek()<nums[i]) third = stack.pop()
        stack.push(nums[i])
    }
    return false
}
private val list = mutableListOf<Int>()
private fun postorderTraversal(root: TreeNode?): List<Int> {
    helper(root)
    return list
}
private fun helper(root:TreeNode?){
    if(root==null) return
    helper(root.left)
    helper(root.right)
    list.add(root.`val`)

}