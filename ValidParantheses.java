import java.util.ArrayList;

import org.graalvm.compiler.hotspot.stubs.OutOfBoundsExceptionStub;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *  
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * 
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * 
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * 
 * Input: s = "{[]}"
 * Output: true
 *  
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'
 */
public class ValidParantheses<E> {

    public static void main(String[] args) {
        String s = "([])";

        ValidParantheses solution = new ValidParantheses();
        System.out.println(solution.isValidParantheses(s));
    }

    /**
     * Checking for valid Parantheses in string s.
     * 
     * step 1: check if length of string is even, if not return false.
     * step 2: start a loop till length of string. // i = 0
     * step 3: if ith character of string is openning parantheses then add it at the end of list.
     * step 4: if ith is closing parantheses , check last character in list is its corresponding opening parantheses or not.
     * step 5 : if yes remove last from list 
     * step 6 ; if not return false.
     * step 7 : after the loop if list is empty return true, if not return false.
     * @param s input string
     * @return parantheses is valid or not
     */
    public boolean isValidParantheses(String s) { // O(n), O(n) when n is even , but O(1), O(1) when n is odd ,where n is length of string s. 
        // If string length is odd then invalid parantheses
        int length = s.length(); // O(1), O(1)
        if(length % 2 != 0) return false; // O(1), O(1)

        // Checking valid Parantheses
        ArrayList<Character> list = new ArrayList<Character>(); // O(1), O(1)
        for(int i = 0; i < length; i++) { // O(n), O(n)
            char current = s.charAt(i); // O(1), O(1)
            int lastIndex = list.size() - 1;  // O(1), O(1)

            // If opening backet then add it to the list and if closing backect then check it and remove it from the list.
            if(isOpeningParantheses(current)) { // O(1), O(1)
                list.add(current); // O(1), O(1)
            } else if(lastIndex >= 0 && isParanthesesMatch(list.get(lastIndex), current)) { // O(1), O(1)
                list.remove(lastIndex); // O(1), O(1)
            } else {
                return false; // O(1), O(1)
            } 
        }
        return list.isEmpty(); // O(1), O(1)
    }

    /**
     * Checking for opening Parantheses
     * 
     * @param ch is charcter of input string
     * @return if ch is opening backect or not.
     */
    public boolean isOpeningParantheses(char ch) { // O(1), O(1)
        return ch =='(' || ch == '{' || ch =='[';
    }

    /**
     * Checking matching Parantheses
     * 
     * @param open is opening parantheses 
     * @param close is closing parantheses
     * @return if paranthese is valid or not.
     */
    public boolean isParanthesesMatch(char open, char close) { // O(1), O(1)
        return (open == '(' && close == ')') || 
        (open == '{' && close == '}') ||
        (open == '[' && close == ']') ;
    }
    
}
