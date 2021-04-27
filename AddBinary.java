import java.util.Arrays;

/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *  
 * 
 * Constraints:
 * 
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(solution.addBinary(a, b));
    }

    /** 
     * Adding two binary strings
     * 
     * Steps: 
     * carry = 0
     * length = maxOf(a.length, b.length)
     * Initilise string builder
     * for i = 0 to length - 1, i++
     *   // If i > any of the length, take value as zero there.
     *   val1 = i > a.length - 1 ? 0 : a[a.length - 1 - i]
     *   val2 = i > b.length - 1 ? 0 : b[b.length - 1 - i]
     *   output[i] = val1 ^ val2 ^ carry
     *   carry = val1 & val2 | val1 & carry | val2 & carry
     * if carry = 1
     *   output = leadingOne(output) // adding leading 1 to output as a carry
     * return str(output)
     * @param str1 is input string
     * @param str2 is input string
     * @return addtion of two input string
     */                                                 
    public String addBinary(String str1, String str2) { 
        int carry = 0; // O(1), O(1)
        int length = maxOf(str1.length(), str2.length()); // O(1), O(1)
        char[] output = new char[length]; // O(1), O(n)
        for(int i = 0; i < length; i++) { // O(n), O(1)
            int val1 = i > str1.length() - 1 ? 0 : str1.charAt(str1.length() - 1 - i) - '0'; // O(1), O(1)
            int val2 = i > str2.length() - 1 ? 0 : str2.charAt(str2.length() - 1 - i) - '0'; // O(1), O(1)
            // Taking xor of val1,val2,carry gives us last digit of the addition
            output[length - 1 - i] = (char)(val1 ^ val2 ^ carry + '0');  // O(1), O(1)
            //  If atleast two values of val1,val2,carry are 1, our carry should be one.
            carry = val1 & val2 | val1 & carry | val2 & carry; // O(1), O(1)
        }
        if(carry == 1) output = leadingOne(output); // O(n), O(n)
        return new String(output); // O(1), O(1)
    }
    
    /**
     * Find maximum length from both the strings.
     * 
     * @param length1 input string 1 length
     * @param length2 input string 2 length
     * @return maximum length
     */
    private int maxOf(int length1, int length2) {
        return length1 >= length2 ? length1 : length2;
    }

    /**
     * Add leading one in output array.
     * 
     * 
     * @param output is char array
     * @return leading one output array
     */
    private char[] leadingOne(char[] output) { // O(n), O(n)
        char[] newOutput = new char[output.length + 1]; // O(1), O(n)
        newOutput[0] = '1'; // O(1), O(1)
        for(int i = 1; i < newOutput.length; i++) { // O(n), O(1)
            newOutput[i] = output[i - 1]; // O(1), 
        }
        return newOutput;
    }

    
}
