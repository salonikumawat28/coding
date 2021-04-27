/**
 * https://leetcode.com/problems/sqrtx/
 * 
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: x = 4
 * Output: 2
 * Example 2:
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *  
 * 
 * Constraints:
 * 
 * 0 <= x <= 231 - 1
 */
public class SqrtX {
    public static void main(String[] args) {
        int x = 545;
        SqrtX solution = new SqrtX();
        System.out.println(solution.mySqrtInFloat(x, 0.01f));
    }

    /**
     * Finding Square root of input integer by using sunstraction method.
     * 
     * Steps:
     * Initialise squareRoot = 0, oddNumber = 1
     * while(nums >= oddNumber)
     *   substract oddNumber from nums
     *   do oddNumber + 2 , for next odd number
     *   squareRoot++
     * At the end of loop return squareRoot.
     * 
     * @param num
     * @return
     */
    public int mySqrtBySubstraction(int nums) { // O(sqrtn), O(1)
        int squareRoot = 0; // O(1), O(1)
        int oddNumber = 1; // O(1), O(1)
        while(nums >= oddNumber) {// O(sqrtn), O(1)
            nums = nums - oddNumber; // O(1), O(1)
            oddNumber += 2; // O(1), O(1)
            squareRoot++; // O(1), O(1)
        }
        return squareRoot; // O(1), O(1)
    }

    /**
     * Finding square root of input(float) using Binary Search.
     * 
     * Steps:
     * Initialise low = 0.01 and high = nums 
     * while (high >= low)
     *   find mid = low + (high - low) / 2
     *   check if mid * mid > nums
     *     change high = mid - 1
     *   else
     *     chnage low = mid + 1    
     * End of loop for binary search
     * return low - 1 since we want to truncate decimal part.
     * 
     * @param nums is input integer
     * @return square root of input 
     */
    public float mySqrtInFloat(float nums , float precision) { // O(log(n/m)), O(1) where n is nums and m is precision
        float low = precision; // O(1), O(1)
        float high = nums; // O(1), O(1)
        while(high >= low) { //O(log(n/m)), O(1)
            float mid = low + (high - low) / 2; // O(1), O(1)
            double midDouble = (double)mid;


            // Here mid is converted into long in order to save overflow bits due to mid*mid expression.
            double midSquare = midDouble * midDouble; // O(1), O(1)
            if(midSquare > nums) high = mid - precision; // O(1), O(1)
            else if(midSquare == nums) return mid;
            else low = mid + precision; // O(1), O(1)
        }
        return low - precision; // O(1), O(1)
    }

    /**
     * Finding square root of input using Binary Search.
     * 
     * Steps:
     * Initialise low = 1 and high = nums
     * while (high >= low)
     *   find mid = low + (high + low) / 2
     *   check if mid * mid > nums
     *     change high = mid - 1
     *   else
     *     chnage low = mid + 1    
     * End of loop for binary search
     * return low - 1 since we want to truncate decimal part.
     * 
     * @param nums is input integer
     * @return square root of input 
     */
    public int mySqrt(int nums) { // O(logn), O(1) 
        int low = 0; // O(1), O(1)
        int high = nums; // O(1), O(1)
        while(high >= low) { //O(logn), O(1)
            int mid = low + (high - low) / 2; // O(1), O(1)
            long midLong = (long) mid;


            // Here long is used in orfer to preserve overflowed bits occured due to mid * mid.
            long midSquare = midLong * midLong;
            if(midSquare > nums) high = mid - 1; // O(1), O(1)
            else if(midSquare == nums) return mid;
            else low = mid + 1; // O(1), O(1)
        }
        return low - 1; // O(1), O(1)
    }


    
}
