package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(canCompleteCircuit2(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
    println(canCompleteCircuit2(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)))
}

private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    if (gas.isEmpty() || gas.size != cost.size) return -1
    val size = gas.size
    for (i in gas.indices) {
        var sum = 0
        var index = i
        do {
            sum += gas[index] - cost[index]
            index++
            index %= size
        } while (sum >= 0 && index != i)
        if (sum >= 0) {
            return i
        }
    }
    return -1
}

private fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
    if (gas.isEmpty() || gas.size != cost.size) return -1
    var start = 0
    var end = gas.size - 1
    var sum = gas[end] - cost[end]
    while (start < end) {
        if (sum >= 0) {
            sum += gas[start] - cost[start]
            start++
        } else {
            end--
            sum += gas[end] - cost[end]
        }
    }
    return if (sum >= 0) start else -1
}