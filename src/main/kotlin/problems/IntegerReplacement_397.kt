package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(4 shr 1)
    println(integerReplacement(8))
}

private fun integerReplacement(n: Int): Int {
    var count = 0
    var temp = n
    while (temp != 1) {
        if (temp and 1 == 0) {
            temp = temp shr 1
        }else if (temp == 3 || (temp shr 1) and 1 == 0) {
            temp--
        }else temp++
        count++
    }

    return count

}