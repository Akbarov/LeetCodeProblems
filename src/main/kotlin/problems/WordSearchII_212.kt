package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        findWords(
            arrayOf(
                charArrayOf('a', 'b'),
                charArrayOf('c', 'd'),
            ), arrayOf("abcd")
        )
    )
}

private val resultList = mutableListOf<String>()
private fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val root = buildTrieNode(words)
    for (i in board.indices) {
        for (j in board[i].indices) {
            dfs(board, i, j, root)
        }
    }
    return resultList
}

private fun dfs(board: Array<CharArray>, i: Int, j: Int, root: TrieNode?) {
    val c = board[i][j]
    if (root == null || c == '#' || root.next[c - 'a'] == null) return

    val p = root.next[c - 'a']
    if (p?.word != null) {
        resultList.add(p.word!!)
        p.word = null
    }
    board[i][j] = '#'
    if (i > 0) dfs(board, i - 1, j, p)
    if (i < board.size - 1) dfs(board, i + 1, j, p)
    if (j > 0) dfs(board, i, j - 1, p)
    if (j < board[0].size - 1) dfs(board, i, j + 1, p)
    board[i][j] = c
}

private fun buildTrieNode(words: Array<String>): TrieNode {
    val root = TrieNode()
    for (w in words) {
        var t: TrieNode? = root
        for (c in w) {
            val index = c - 'a'
            if (t?.next?.get(index) == null) t?.next?.set(index, TrieNode())
            if (t != null) {
                t.next[index].also { t = it }
            }
        }
        t?.word = w
    }
    return root
}

data class TrieNode(var word: String? = null) {
    val next = Array<TrieNode?>(26) { null }
}