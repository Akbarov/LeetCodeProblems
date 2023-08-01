package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(partitionLabels("ababcbacadefegdehijhklij"))
    println(partitionLabels("eccbbbbdec"))

}

private fun partitionLabels(s: String): List<Int> {

    val array = IntArray(26)
    for ((i, c) in s.withIndex()) {
        array[c - 'a'] = max(array[c - 'a'], i)
    }
    println(array.joinToString())
    val result = mutableListOf<Int>()
    var lastIndex = 0
    var prevIndex = -1
    for ((i, c) in s.withIndex()) {
        lastIndex = max(array[c - 'a'], lastIndex)
        if (i == lastIndex){
            result.add(lastIndex - prevIndex )
            prevIndex = lastIndex
        }

    }
    return result
}