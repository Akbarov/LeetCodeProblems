package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16)
    result.forEach {
        println(it)
    }
}

private fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {

    val result = mutableListOf<String>()
    var i = 0
    while (i < words.size) {
        val lineWords = getLine(words, i, maxWidth)
        i += lineWords.size
        val line = createBeautyLine(lineWords, maxWidth, i == words.size)
        result.add(line)

    }
    return result
}

private fun createBeautyLine(currentList: List<String>, maxWidth: Int, isLastLine: Boolean): String {
    val sb = StringBuilder()
    val wordCount = currentList.size-1
    var neededSpaces = maxWidth - currentList.sumOf { it.length }
    if (currentList.size == 1) {
        return currentList.first() + " ".repeat(neededSpaces)
    }
    if (isLastLine) {
        return currentList.joinToString(" ") + " ".repeat(neededSpaces - wordCount)
    }

    val spacePerWord = neededSpaces / wordCount
    var extraSpace = neededSpaces % wordCount

    var i = 0
    while (i < wordCount) {
        sb.append(currentList[i])
        if (extraSpace-- > 0) {
            sb.append(" ")
        }
        sb.append(" ".repeat(spacePerWord))
        i++
    }
    sb.append(currentList.last())

    return sb.toString()


}

private fun getLine(words: Array<String>, index: Int, maxWidth: Int): List<String> {
    var tempWidth = 0
    var i = index
    val result = mutableListOf<String>()
    while (i < words.size && tempWidth + words[i].length <= maxWidth) {
        tempWidth += words[i].length + 1
        result.add(words[i])
        i++
    }
    return result
}