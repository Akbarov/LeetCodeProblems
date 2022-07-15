package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

val hashtable = mutableMapOf<Int, NodeWithChildren>()
private fun cloneGraph(node: NodeWithChildren?): NodeWithChildren? {
    if (node == null) return null
    val copyNode = NodeWithChildren(node.`val`)
    helper(node, copyNode)
    return copyNode
}

private fun helper(node: NodeWithChildren, copy: NodeWithChildren) {
    hashtable[node.`val`] = copy
    node.neighbors?.forEach {
        it?.apply {
            if (`val` in hashtable) {
                copy.neighbors?.add(hashtable[`val`])
            } else {
                val temp = NodeWithChildren(`val`)
                copy.neighbors?.add(temp)
                helper(node, temp)
            }
        }
    }
}