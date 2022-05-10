package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(generateParenthesis(3).joinToString())
}

private fun generateParenthesis(n: Int): List<String> {
    val list = mutableListOf<String>()
    bfs(n,n,"",list)
    return list
}
private fun bfs(open:Int,close:Int,s:String,list: MutableList<String>){
    if (open<0||close<0)return
    if (open==0&&close==0){
        list.add(s)
        return
    }
    if (open>0){
        bfs(open-1,close, "$s(",list)
    }
    if (close > open) {
        bfs(open,close-1, "$s)",list)
    }
}