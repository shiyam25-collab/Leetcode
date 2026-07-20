import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        // Map closing brackets to their corresponding opening brackets
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            
            // If the character is a closing bracket
            if (bracketMap.containsKey(charAt)) {
                // Get the top element of the stack, or use a dummy value if it's empty
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                
                // If it doesn't match the mapped opening bracket, it's invalid
                if (topElement != bracketMap.get(charAt)) {
                    return false;
                }
            } else {
                // If it's an opening bracket, push it onto the stack
                stack.push(charAt);
            }
        }
        
        // If the stack is empty, all brackets were properly matched
        return stack.isEmpty();
    }
}
