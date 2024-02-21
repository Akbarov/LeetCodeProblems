package problems


/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

fun decodeAtIndex(s: String, k: Int): String {
    var length = 0L
    var K = k.toLong()
    for (c in s) {
        if (c in '1'..'9') {
            length *= (c - '0')
        } else length++
    }
    for (c in s.reversed()) {
        if (c in '1'..'9') {
            length /= (c - '0')
            K %= length
        } else {
            if (K % length == 0L) return "$c"
            length--
        }
    }
    return ""
}
