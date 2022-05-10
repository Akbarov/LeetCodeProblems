
/**
Creator: Zohidjon Akbarov
 */
fun main() {
 val array = arrayOf(1,2,4)
    array.sortDescending()
}

private class Codec() {
    // Encodes a URL to a shortened URL.
    val map = mutableMapOf<String, String>()
    fun encode(longUrl: String): String {
        val sb = StringBuilder()
        do {
            sb.append((Math.random() * 100).toInt().toChar())
        } while (map.containsKey(sb.toString()))
        map[sb.toString()] = longUrl
        return sb.toString()
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return map[shortUrl]?:""
    }
}
