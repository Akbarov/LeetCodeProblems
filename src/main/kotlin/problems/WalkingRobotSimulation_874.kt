package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(robotSim(intArrayOf(1, -2, 3, 4, -1, 4), arrayOf(intArrayOf(2, 4))))
}

private fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
    val set = mutableSetOf<String>()
    for (obs in obstacles) {
        set.add("${obs[0]}-${obs[1]}")
    }
    var result = 0
    var x = 0
    var y = 0
    val dir = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
    var d = 0
    for (com in commands) {
        when (com) {
            -1 -> {
                d++
                if (d == 4) d = 0
            }
            -2 -> {
                d--
                if (d == 0) d = 3
            }
            else -> {
                while ("${x + dir[d][0]}-${y + dir[d][1]}" !in set) {
                    x += dir[d][0]
                    y += dir[d][1]
                    result = Math.max(result, x * x + y * y)
                }
            }
        }
    }
    return result

}