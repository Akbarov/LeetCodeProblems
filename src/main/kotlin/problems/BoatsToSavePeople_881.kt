package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numRescueBoats(intArrayOf(1, 2), 3))
    println(numRescueBoats(intArrayOf(3, 2, 1, 2), 3))
    println(numRescueBoats(intArrayOf(3, 4, 5, 3), 5))
    println(numRescueBoats(intArrayOf(1, 1, 4, 4), 5))
}

private fun numRescueBoats(people: IntArray, limit: Int): Int {

    var count = 0
    people.sort()
    var l = 0
    var r = people.lastIndex
    while (l <= r) {
        if (people[l] + people[r] <= limit) {
            l++
        }
        r--
        count++
    }

    return count
}