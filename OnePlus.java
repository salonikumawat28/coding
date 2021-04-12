/**
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * 
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 * 
 * Input: digits = [0]
 * Output: [1]
 *  
 * 
 * Constraints:
 * 
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class OnePlus {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        OnePlus solution = new OnePlus();
        System.out.println(solution.plusOne(digits));

    }
    
    /** 
     * Adding one to array, considering array as a number.
     * 
     * Steps: //80
     * 1. Start a for loop i from array.length-1 to 0 // i=0 ; i < = 0
     * 2. Check if array[i] < 9, array[i] + 1, return array.
     * 3. Else array[i] = 0 
     * 4. after the for loop, update array = [1, all zeros]
     * 4. At the end  return array.
     * @param digits is input array
     * @return updated array by adding one to it.
     */
    public int[] plusOne(int[] digits) { // O(n), O(n) where n is length of input array.
        for(int i = digits.length - 1; i >= 0; i--) { // O(n), O(1)
            if(digits[i] < 9) { // O(1), O(1)
                digits[i] = digits[i] + 1; // O(1), O(1)
                return digits; // O(1), O(1)
            }
            else {
                digits[i] = 0; // O(1), O(1)
            }
        }
        digits = new int[digits.length + 1]; // O(1), O(n)
        digits[0] = 1; // O(1), O(1)
        return digits; // O(1), O(1)
    }
    
}
