Problem:
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,word,0,i,j)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word,int index,int i,int j){
        if(board[i][j]!=word.charAt(index)) return false;
        if(index==word.length()-1) return true;
        char c=board[i][j];
        board[i][j]=' ';
        boolean exist=false;
        if(i>0){
             exist|=backtrack(board,word,index+1,i-1,j);
             if(exist) return exist;
        } 
        if(j>0)  {
            exist|=backtrack(board,word,index+1,i,j-1);
            if(exist) return exist;
        }
        if(i<board.length-1){
            exist|=backtrack(board,word,index+1,i+1,j);
            if(exist) return exist;
        }  
        if(j<board[0].length-1) {
            exist|=backtrack(board,word,index+1,i,j+1);
            if(exist) return exist;
        } 
         board[i][j] =c;
        return exist;
    }
}
