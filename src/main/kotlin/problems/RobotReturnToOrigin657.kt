package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
  println(judgeCircle("UD"))
  println(judgeCircle("LL"))
}

private fun judgeCircle(moves: String): Boolean {
    var x = 0
    var y = 0
    for (c in moves) {
        when (c) {
            'U' -> y++
            'D' -> y--
            'R' -> x++
            'L' -> x--
        }
    }
    return x == 0 && y == 0
}