package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(reorderedPowerOf2(8))
println(reorderedPowerOf2(10))
println(reorderedPowerOf2(1))
}

private fun reorderedPowerOf2(n: Int): Boolean {
    val sorted = n.toString().toCharArray().sorted().joinToString("")
    for (i in 0..31) {
        val powN = (1 shl  i).toString().toCharArray().sorted().joinToString("")
        if (sorted==powN) return true
    }
    return false
}
