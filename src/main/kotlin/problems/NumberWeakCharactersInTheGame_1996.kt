package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */

/***
 * You are playing a game that contains multiple characters,
 * and each of the characters has two main properties: attack and defense.
 * You are given a 2D integer array properties
 * where properties[i] = [attacki, defensei]
 * represents the properties of the ith character in the game.
 * A character is said to be weak if any other character has both attack
 * and defense levels strictly greater than this character's attack and defense levels.
 * More formally, a character i is said to be weak if there exists another character
 * j where attackj > attacki and defensej > defensei.
 * Return the number of weak characters.
 */
fun main() {
    println(numberOfWeakCharacters(arrayOf(
        intArrayOf(1,1),
        intArrayOf(2,1),
        intArrayOf(2,2),
        intArrayOf(1,2),
    )))
}

private fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
    var count = 0
    properties.sortWith(Comparator { o1, o2 -> if (o1[0] == o2[0]) o2[1] - o1[1] else o1[0] - o2[0] })
    for (a in properties) {
        println(a.joinToString())
    }
    var maxV = Int.MIN_VALUE
    for (i in properties.lastIndex downTo 0) {
        if (properties[i][1] < maxV) {
            count++
        }
        maxV = max(maxV, properties[i][1])
    }
    return count
}