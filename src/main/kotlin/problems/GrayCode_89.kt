package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(grayCode(5).joinToString())
}

private fun grayCode(n: Int): List<Int> {
    val list = mutableListOf<Int>()

    for (i in 0 until (n shl 1)) {
        val temp = i xor i shr 1
        list.add(temp)
    }
    return list
}