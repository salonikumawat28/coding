/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: s = "Hello World"
 * Output: 5
 * Example 2:
 * 
 * Input: s = " "
 * Output: 0
 *  
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        String s = "Hello World";
        System.out.println(solution.lengthOfLastWord(s));
    }
    
    /**
     * Find Length of last word of the input string.
     * 
     * Steps:
     * 1. Initialise length as s.length.
     * 1. Start a for loop i from s.length - 1 to o.
     * 2. Check if s[i] == ' ',length--.
     * 3. else break
     * 4. Start a for loop i from length to 0
     * 5. Check if s[i] == ' ', return length - i - 1;
     * 6. At The end of loop return length.
     * 
     * @param str is input string
     * @return count of length of last word of string.
     */
    public int lengthOfLastWord(String str) { // O(n), O(1) where n is length of input string 
        int length = str.length(); // O(1), O(1)
        for(int i = length - 1; i >= 0; i--) { // O(n), O(1)
            if(str.charAt(i) != ' ') break; // O(1), O(1)
            length--; // O(1), O(1)
        }
        for(int i = length - 1; i >= 0 ; i--) { // O(n), O(1)
            if(str.charAt(i) == ' ') return length - i - 1; // O(1), O(1)
        }
        return length; // O(1), O(1)
    }

}
