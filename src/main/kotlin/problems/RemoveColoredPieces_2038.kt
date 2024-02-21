package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(winnerOfGame("AAAABBBB"))
}

private fun winnerOfGame(colors: String): Boolean {
    var removableA = 0
    var removableB = 0
    var count = 0
    for (c in colors) {
        if (c == 'A') {
            count++
        } else {
            if (count > 2) {
                removableA += count - 2
            }
            count = 0
        }
    }
    if (count > 2) {
        removableA += count - 2
    }
    count = 0
    for (c in colors) {
        if (c == 'B') {
            count++
        } else {
            if (count > 2) {
                removableB += count - 2
            }
            count = 0
        }
    }
    if (count > 2) {
        removableB += count - 2
    }
    return removableA > removableB
}