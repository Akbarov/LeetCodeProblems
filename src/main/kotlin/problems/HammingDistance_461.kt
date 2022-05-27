package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(hammingDistance(15,5))
//    println(hammingDistance(3,1))
}

private fun hammingDistance(x: Int, y: Int): Int {
    var xorD = x xor y
    var count = 0
    while (xorD > 0) {
        println(xorD)
        if (xorD % 2 == 1) {
            count++
        }
        xorD = xorD shr  1
    }
    return count
}