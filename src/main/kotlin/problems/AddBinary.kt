package problems

fun main() {
    println(
        addBinary(
                "1011",
            "110101"
        )
    )
}

private fun addBinary(a: String, b: String): String {
    val size = if (a.length > b.length) a.length else b.length
    val builder = StringBuilder()
    var temp = 0
    for (i in 0 until size) {
        if (i < a.length) {
            temp += a[a.lastIndex - i]-'0'
        }
        if (i < b.length) {
            temp += b[b.lastIndex - i]-'0'
        }
        builder.append(temp % 2)
        temp /= 2
    }
    if (temp == 1) {
        builder.append(temp)
    }
    return builder.reverse().toString()
}