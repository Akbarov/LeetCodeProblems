/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var result = combinationSum3(9, 45)
    for (a in result) {
        println(a.joinToString())
    }
    println("----------------")
    result = combinationSum3(3, 9)
    for (a in result) {
        println(a.joinToString())
    }
    println("----------------")
    result = combinationSum3(3, 7)
    for (a in result) {
        println(a.joinToString())
    }
    println("----------------")
}

private lateinit var list: MutableList<MutableList<Int>>

private fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    list = mutableListOf()
    helper(k, n, mutableListOf(), 0)
    return list

}

private fun helper(k: Int, n: Int, sub: MutableList<Int>, index: Int) {
    if (sub.sum() > n || k < sub.size) {
        return
    }
    if (sub.sum() == n && k == sub.size) {
        val temp = mutableListOf<Int>()
        temp.addAll(sub)
        list.add(temp)
    }
    for (i in index+1..9-k+sub.size+1 ) {
        sub.add(i)
        helper(k, n, sub, i)
        sub.removeAt(sub.lastIndex)
    }
}