import algorithm_I.TreeNode

/**
Creator: Zohidjon Akbarov
 */
fun main() {



}

private class Code() {
    private lateinit var sb: StringBuilder
    private var index = 0
    fun serialize(root: TreeNode?): String {
        sb = StringBuilder()
        preOrder(root)
        return sb.toString()
    }

    private fun preOrder(root: TreeNode?) {
        if (root == null) {
            sb.append("()")
        }
        sb.append("(${root?.`val`}")
        preOrder(root?.left)
        preOrder(root?.right)
        sb.append(")")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        index = 0
        return decode(data)
    }

    private fun decode(data: String): TreeNode? {
        index++
        if (data[index] == ')') {
            return null
        }
        var number = 0
        var isNegative = false
        if (data[index] == '-') {
            isNegative = true
            index++
        }
        while (data[index] != '(') {
            number *= 10
            number += data[index] - '0'
            index++
        }
        val root = TreeNode(if (isNegative) -1 * number else number)
        root.left = decode(data)
        index++
        root.right = decode(data)
        index++
        return root
    }


}