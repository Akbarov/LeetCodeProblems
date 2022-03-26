package algorithm_I

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

object Generate {
    fun generateTreeNode(list: List<Int?>): TreeNode? {
        if (list.isEmpty()) return null
        val root = TreeNode(list.first() ?: 0)
        return root
    }

    private fun bfs(root: TreeNode, list: List<Int?>, count: Int) {
        if (count >= list.lastIndex) return

    }
}