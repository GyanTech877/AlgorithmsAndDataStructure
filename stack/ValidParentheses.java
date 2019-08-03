/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        Map<Character,Character> map=new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            Character currentChar=s.charAt(i);
                if(map.containsKey(currentChar)){
                    if(stack.isEmpty()||(
                    (map.get(currentChar)!=stack.pop()))) return false;
                }
                else{
                    stack.push(currentChar);
                }
            }
        return stack.isEmpty();
        }
    }
