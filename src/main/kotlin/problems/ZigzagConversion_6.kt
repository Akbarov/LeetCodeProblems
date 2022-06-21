package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(convert("PAYPALISHIRING",3))
println(convert("PAYPALISHIRING",4))
}

private fun convert(s: String, numRows: Int): String {
    if (numRows==1||s.length==1) return s
    val array = Array(numRows) { StringBuilder("") }
    var row = 0
    var isUp = false
    for (c in s) {
        array[row].append(c)
        row = if (isUp) row - 1 else row + 1
        if (row == 0 || row == numRows - 1) isUp = !isUp
    }
    val stringBuilder = StringBuilder()
    for (a in array) {
        stringBuilder.append(a)
    }
    return stringBuilder.toString()
}