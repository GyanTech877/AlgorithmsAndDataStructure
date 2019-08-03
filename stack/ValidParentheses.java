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
