package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(restoreIpAddresses("101023"))
}

private var result = mutableListOf<String>()
private fun restoreIpAddresses(s: String): List<String> {
    dfs(s, 0, "")
    return result
}

private fun dfs(s: String, count: Int, current: String) {
    if (count == 4) {
        if (s.isEmpty())
            result.add(current)
        return
    }
    var ip = 0
    for (i in s.indices) {
        ip *= 10
        ip += (s[i] - '0')
        if (ip > 255 || (i > 0 && ip < 10)) break
        if (current.isEmpty()) {
            dfs(s.substring(i + 1), count + 1, "$ip")
        } else {
            dfs(s.substring(i + 1), count + 1, "$current.$ip")
        }
    }
}