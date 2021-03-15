import org.graalvm.compiler.replacements.StandardGraphBuilderPlugins.StringIndexOfConstantPlugin;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: x = 123
 * Output: 321
 * Example 2:
 * 
 * Input: x = -123
 * Output: -321
 * Example 3:
 * 
 * Input: x = 120
 * Output: 21
 * Example 4:
 * 
 * Input: x = 0
 * Output: 0
 *  
 * 
 * Constraints:
 * 
 * -2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1234));
        System.out.println(reverseByCharArray("saloni"));
        System.out.println(reverseByStringAdd("mehul"));
        System.out.println(reverseByBuilder("Abhishek"));
    }

    /**
     * Reversing the iput integer.
     * 
     * Getting each digit in reverse fashion and creating reverse integer using (a * 10 + b) concept.
     * @param x input integer to reverse
     * @return reverse integer
     */
    public static int reverse(int x) { // TC = O(n), SC = O(1), where n is number of digits in x.
        int reverse = 0; // TC = O(1), O(!)
        while(x != 0) {  // TC = O(n), SC = O(1)
            reverse = reverse * 10 + (x % 10);  // TC = O(1), SC O(1)
            x = x / 10; // TC O(1), SC = O(1)
        }
        return reverse; // TC = O(1), SC = O(1)
    }

    /**
     * Reversing the input string 
     * 
     * Getting each character in reverse fashion and storing it in a new char array.
     * @param str input String to reverse
     * @return reverse string
     */
    public static String reverseByCharArray(String str) { // TC = O(n), SC = O(n), where n is length of str.
        int length = str.length(); // TC = O(1), SC = O(1)
        char[] reverseArr = new char[length]; // TC = O(1), SC = O(n)
        for(int i = 0; i < length; i++) { // TC = O(n), SC = O(1)
            reverseArr[i] = str.charAt(length - i - 1); // TC = O(1), SC = O(1)
        }
        
        return new String(reverseArr); // TC = O(n), SC = O(1)
    }

    /**
     * Reversing the input String
     * 
     * Getting each character in reverse fashion and storing it in new String by using ' + ' operator.
     * @param str input String to reverse
     * @return reverse String
     */
    public static String reverseByStringAdd(String str) { // TC = O(n ^ 2), SC = O(n) , where n is length of input String.
        int length = str.length(); // TC = O(1), SC = O(1)
        String newStr = ""; // TC = O(1), SC = O(1)
        for(int i = 0; i < length; i++) { // TC = O(n ^ 2), SC = O(n)
            newStr = newStr + str.charAt(length - i - 1); // TC = O(i), SC = O(i)
        }
        return newStr; // TC = O(1), SC = O(1)
    }

    /**
     * Reversing the input string
     * 
     * Getting each character in reverse fashion and storing it in String Builder.
     * @param str input String to reverse
     * @return reverse String
     */
    public static String reverseByBuilder(String str) { // TC = O(n), SC = O(n), where n is lenth of input string.
        int length = str.length(); // TC = O(1), SC = O(1)
        StringBuilder builder = new StringBuilder(); // TC = O(1), SC = O(1)
        for(int i = 0; i < length; i++) { // TC = O(n), SC = O(1)
            builder.append(str.charAt(length - i - 1)); // TC = O(1), SC = O(1)
        }
        return builder.toString(); // TC = O(n), SC = O(n)
    }

}