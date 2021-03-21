import org.graalvm.compiler.nodes.NodeView.Default;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: s = "III"
 * Output: 3
 * Example 2:
 * 
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 * 
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 * 
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * 
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *  
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    public static void main(String[] args) {
        String  s = "MCMXCIV";
        System.out.println(romanToInteger(s));
    }

    /**
     * Roman to Integer conversion
     * 
     * Finding roman string and then find roman integer of respected roman string.
     * @param s input string
     * @return roman number
     */
    public static int romanToInteger(String s) { // O(n), O(1) where n is lengthof string s.
        int length = s.length(); // O(1), O(1)
        int i = 0, number = 0; // O(1), O(1)
        while(i < length) { // O(n), O(1)
            String roman = findRomanString(s, i); // O(1), O(1)
            number += romanInteger(roman); // O(1), O(1)
            i += roman.length(); // O(1), O(1)
        }
        return number; // O(1), O(1)
    }

    /**
     * Finding roman string
     * 
     * If input string is special case then return two character otherwise return one character.
     * @param str input string
     * @param index
     * @return roman string
     */
    private static String findRomanString(String str, int index) { // O(1), O(1)
        boolean isSpecialCase = index != str.length() - 1 && isSpecialCase(str, index); // O(1), O(1)
        String romanValue = "" + str.charAt(index); // O(1), O(1)
        if(isSpecialCase) romanValue += str.charAt(index + 1); // O(1), O(1)
        return romanValue; // O(1), O(1)
    }

    /**
     * Checking Special case of roman string
     * 
     * @param str input string
     * @param index where to check the special case
     * @return special case or not.
     */
    private static boolean isSpecialCase(String str, int index) { // O(1), O(1)
        return (str.charAt(index) == 'I' && str.charAt(index + 1) == 'V') || 
        (str.charAt(index) == 'I' && str.charAt(index + 1) == 'X') ||
        (str.charAt(index) == 'X' && str.charAt(index + 1) == 'L') ||
        (str.charAt(index) == 'X' && str.charAt(index + 1) == 'C') ||
        (str.charAt(index) == 'C' && str.charAt(index + 1) == 'D') ||
        (str.charAt(index) == 'C' && str.charAt(index + 1) == 'M');
    }

    /**
     * Roman to integer conversion value.
     * 
     * @param roman input string
     * @return roman value to integer
     */
    private static int romanInteger(String roman) { // O(1), O(1)
        switch(roman) {
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            case "IV": return 4;
            case "IX": return 9;
            case "XL": return 40;
            case "XC": return 90;
            case "CD": return 400;
            case "CM": return 900;
            default: throw new IllegalStateException("Invalid Expression"); 
        }
    }
}
