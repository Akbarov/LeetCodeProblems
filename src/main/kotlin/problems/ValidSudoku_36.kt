package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(
        isValidSudoku(
            arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
            )
        )
    )

}
private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val sudo = Array(9){BooleanArray(9)}
    for(i in 0 until 9){
        for(j in 0 until 9){
            if(board[i][j]=='.') continue
            if(i%3==0&&j%3==0){
                if(!check3x3(board,i,j)) {
                    return false
                }
            }
            val n = board[i][j]-'1'
            if(sudo[i][n]) {
                return false
            }
            sudo[i][n] = true
            for(r in 0 until 9){
                if(r!=i&&board[r][j]!='.'&&board[r][j]==board[i][j])return false
            }
        }
    }
    return true
}
fun check3x3(board:Array<CharArray>,i:Int,j:Int):Boolean{
    val ar = BooleanArray(9)
    for(l in 0 until 3){
        for(t in 0 until 3){
            if(board[i+l][j+t]=='.') continue
            val n = board[i+l][j+t]-'1'
            if(ar[n]) return false
            ar[n] = true
        }
    }
    return true
}