/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *  
 * 
 * Constraints:
 * 
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * Finding longest common prefix.
     * 
     * Checking each character of string in array for longest common prefix.
     * @param strs input string array
     * @return longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) { // O(mn), O(m) where n is length of string array strs and m is length of string in array.
        // Checking corner cases
        if(strs.length == 0) return "";

        // Finding the longest common prefix
        int shortestLength = findShortestStringLength(strs); // O(n), O(1)
        StringBuilder stringBuilder = new StringBuilder(); // O(1), O(1)
        for(int i = 0; i < shortestLength; i++) {  // O(mn), O(1)
            boolean allCharactersEqual = checkAllCharactersEqual(strs, i);// O(n), O(1)
            if(!allCharactersEqual) break;
            stringBuilder.append(strs[0].charAt(i)); // O(1), O(1) 
        }
        return stringBuilder.toString(); // O(m), O(m)
    }

    /**
     * Finding shortest string length
     * 
     * Comapring each string in array for shortest length.
     * @param strs input string array
     * @return shortest length of string
     */
    private static int findShortestStringLength(String[] strs) { // O(n), O(1) where n is length of string array strs.
        int shortestLength = strs[0].length(); // O(1), O(1)
        for(int i = 0; i < strs.length; i++) { // O(n), O(1)
            if(shortestLength > strs[i].length()) shortestLength = strs[i].length(); // O(1), O(1)
        }
        return shortestLength ; // O(1), O(1)
    }

    /**
     * Checking if all characters of each string at given index in array are equal.
     * 
     * @param strs input string array
     * @param index at which to check all characters.
     * @return if characters are true or not.
     */
    private static boolean checkAllCharactersEqual(String[] strs, int index) { // O(n), O(1) where n is length of input string array.
        for(int i = 0; i < strs.length - 1; i++) { // O(n), O(1)
            if(strs[i].charAt(index) != strs[i + 1].charAt(index)) return false; // O(1), O(1)
        }
        return true; // O(1), O(1)
    }

}