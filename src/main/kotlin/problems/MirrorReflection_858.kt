package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun mirrorReflection(p: Int, q: Int): Int {
    if (p % q == 0) {
        return if ((p / q) % 2 == 0) 2 else 1
    }
    var temp = q
    while (temp % p != 0) {
        temp += q
    }
    return if ((temp / p) % 2 == 0) 0
    else {
        if ((temp / q) % 2 == 0) 2 else 1
    }
}