package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countBits(5).joinToString())
    println(countBits(2).joinToString())
}

private fun countBits(n: Int): IntArray {
    val list = mutableListOf<Int>()
    var i = 0
    while (i <= n) {
        var sum = 0
        var num = i
        while (num != 0) {
            sum += num% 2
            num /= 2
        }
        list.add(sum)
        i++
    }
    return list.toIntArray()
}