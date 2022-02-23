package algorithm_I.day_14_bit_manipulation

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(reverseBits(43261596))
}

private fun reverseBits(n: Int): Int {
    var chars = n.toUInt().toString(2).padStart(Int.SIZE_BITS,'0').toCharArray()
    println(chars.joinToString())
    var result = 0
    var power2 = 1
    for (c in chars) {
        result += (c - '0') * power2
        power2 *= 2
    }
    return result
}
