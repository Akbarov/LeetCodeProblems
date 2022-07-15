package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(minPartitions("27346209830709182346"))
println(minPartitions("82734"))
}

private fun minPartitions(n: String): Int {
    var maxValue = 0
    for (c in n) {
        if (c-'0'>maxValue) maxValue = c-'0'
    }
    return maxValue
}