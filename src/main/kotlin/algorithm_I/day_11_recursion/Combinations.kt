package algorithm_I.day_11_recursion

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    combine(4, 2)
    println(result.joinToString())

}

val result = mutableListOf<List<Int>>()

private fun combine(n: Int, k: Int): List<List<Int>> {
    return if (n < k) {
        emptyList()
    } else if (n == k) {
        val list = mutableListOf<Int>()
        for (i in 1..n) {
            list.add(i)
        }
        result.add(list)
        result
    } else {
        recursion(n, 1, k, mutableListOf())
        result
    }
}

private fun recursion(n: Int, start: Int, k: Int, list: MutableList<Int>) {
    println("$start => ${list.joinToString()}")
    if (list.size == k) {
        val temp = mutableListOf<Int>()
        temp.addAll(list)
        result.add(temp)
    }
    for (i in start..n) {
        list.add(i)
        recursion(n, i + 1, k, list)
        list.removeAt(list.lastIndex)
    }
}