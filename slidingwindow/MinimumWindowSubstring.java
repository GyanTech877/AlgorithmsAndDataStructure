Problem:
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null) return "";
        int[] map=new int[128];
        for(Character c:t.toCharArray()){
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        char[] arr=s.toCharArray();
        while(end<arr.length){
             if (map[arr[end++]]-- > 0) counter--;
             while(counter==0){
                 if((end-start)<minLen){
                     minLen=end-start;
                     minStart=start;
                 }
                 if(map[arr[start++]]++==0)counter++;
             }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
