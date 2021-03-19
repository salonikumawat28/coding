/**
 * Given an integer x, return true if x is palindrome integer.
 * 
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: x = 121
 * Output: true
 * Example 2:
 * 
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * 
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 * 
 * Input: x = -101
 * Output: false
 *  
 * 
 * Constraints:
 * 
 * -2^31 <= x <= 2^31 - 1
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int nums = 2147447412;
        System.out.println(isPalindrome(nums));
        System.out.println(isPalindromeByCharArray("abcba"));
        System.out.println(isPalindromeByStringAdd("abcba"));
        System.out.println(isPalindromeByStringBuilder("abcba"));
        System.out.println(isPalindromeByHalf("nitin"));
    }

    /**
     * Palindrome Check for Input strimg.
     * 
     * Getting reverse of input integer and comparing it with input integer
     * @param x input integer
     * @return boolean expression
     */
    public static boolean isPalindrome(int x) { // TC = O(n), SC = O(1), where n is length of x.
        // Handling negative cases.
        if(x < 0) return false;// TC = O(1), SC = O(1)

        // Finding the reverse.
        long rev = reverse(x); 
        if(rev > Integer.MAX_VALUE) return false;

        // Comparing reverse and original.
        return x == rev; // TC = O(n), SC = O(1)  
    }

    /**
     * Reversing the input integer.
     * 
     * Getting each integer in reverse fashion and creating a reverse string by using (a * 10 + b)
     * @param x input integer
     * @return reverse integer
     * 
     * Note: This is code duplicacy. Better to reuse ReverseInteger.reverse(int x)
     */
    public static long reverse(int x) { // TC = O(n), SC = O(1), where n is length of x.
        long reverse = 0; // TC = O(1), SC = O(1)
        while(x != 0) { // TC = O(n), SC = O(1)
            reverse = reverse * 10 + (x % 10); // TC = O(1), SC = O(1)
            x = x / 10; // TC = O(1), SC = O(1)
        }
        return reverse; // TC = O(1), SC = O(1)
    }

    /**
     * Palindrome Checking of input String.
     * 
     * Reversing the input String by using new char array and then comparing it with original String.
     * @param str input String
     * @return palindrome String check
     */
    public static boolean isPalindromeByCharArray(String str) { // TC = O(n), SC = O(n) where n is length of input String.
        // Finding the reverse of str.
        int length = str.length(); // TC = O(1), SC = O(1)
        char[] reverse = new char[str.length()]; // TC = O(1), SC = O(n)
        for(int i = 0; i < length; i++) { // TC = O(n), SC = O(1)
            reverse[i] = str.charAt(length - i - 1); // TC = O(1), SC = O(1)
        }

        // Comparing reverse and original.
        return str.equals(new String(reverse)); // TC = O(n), SC = O(n)
    }

    /**
     * Finding Palindrome check of input string.
     * 
     * Reversing the input string by using + operator and then comparing it with original string.
     * @param str input string
     * @return Palindrome string check
     */
    public static boolean isPalindromeByStringAdd(String str) { // TC = O(n^2), SC = O(n), where n is length of input string.
        // Finding the reverse of str.
        int length = str.length(); // TC = O(1), SC = O(1)
        String reverse = ""; // TC = O(1), SC = O(1)
        for(int i = 0; i < length; i++) { // TC = O(n^2), SC = O(n)
            reverse = reverse + str.charAt(length- i - 1); // TC = O(i), Sc = O(i)
        }

        // Comparing the original string and reverse string.
        return str.equals(reverse); // TC = O(n), SC = O(1)
    }

    /**
     * Palindrome check of input string.
     * 
     * Reversing the input string using string builder and then comparing it with input string.
     * @param str
     * @return Palindrome string check
     */
    public static boolean isPalindromeByStringBuilder(String str) { // TC = O(n), SC = O(n) where n is length of input string.
        // Finding the reverse of input string
        int length = str.length(); // TC = O(1), SC = O(1)
        StringBuilder stringBuilder = new StringBuilder(); // TC = O(1), SC = O(1)
        for(int i = 0; i < length; i++) { // TC = O(n), SC = O(n) 
            stringBuilder.append(str.charAt(length - i - 1)); // TC = O(1), SC = O(1)
        }

        // Comparing reverse with original string
        return str.equals(stringBuilder.toString()); // TC = O(n), SC = O(n)
    }

    /**
     * Palindrome check of input string.
     * 
     * Comparing first half of input string with other half in reverse fashion.
     * @param str input string
     * @return palindrome string check
     */
    public static boolean isPalindromeByHalf(String str) { // TC = O(n), SC = O(1) where n is length of input string.
        int length = str.length(); // TC = O(1), SC = O(1)
        for(int i = 0; i < length / 2; i++) { // TC = O(n), SC = O(1)
            if(str.charAt(i) != str.charAt(length - i -1)) return false; // TC = O(1), SC O(1)
        }
        return true;
    }
    
}
