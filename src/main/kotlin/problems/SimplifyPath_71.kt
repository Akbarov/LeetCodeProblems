package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(simplifyPath("/home//foo/"))
    println(simplifyPath("/../"))
}

private fun simplifyPath(path: String): String {
    val list = path.split("/").filter { it.isNotBlank() }
    val stack = Stack<String>()
    for (item in list) {
        when (item) {
            "." -> {}
            ".." -> {
                if (stack.isNotEmpty()) stack.pop()
            }
            else -> stack.push(item)
        }
    }
    val sb = StringBuilder()
    if (stack.isEmpty()) sb.append("/")
    while (stack.isNotEmpty()) {
        sb.insert(0,"/${stack.pop()}")
    }
    return sb.toString()
}