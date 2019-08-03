/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList();
        backTrack(n,result,0,0,new StringBuilder());
        return result;
    }
    private void backTrack(int n,List<String> result,int open,int close,StringBuilder curr){
        if(open==n && close==n){
            result.add(curr.toString());
            return;
        }
        if(open<n){
            curr.append("(");
            backTrack(n,result,open+1,close,curr);
            curr.setLength(curr.length()-1);
        }
        if(close<open){
            curr.append(")");
            backTrack(n,result,open,close+1,curr);
            curr.setLength(curr.length()-1);
        }
    }
}
