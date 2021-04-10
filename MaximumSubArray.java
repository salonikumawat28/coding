/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * 
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * 
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *  
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray solution = new MaximumSubArray();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};

    }
    
    /**                                     
     * Maximum sum of contiguous array. 
     * 
     * Steps:
     * 1. Initialise windowSum = nums[0], maxSum = nums[0], start = 0, end = 0.
     * 2. Start a for loop i from 1 to nums length - 1. 
     * 3. Check if windowSum + nums[i] >= nums[i], end++, windowSum = windowSum + nums[i]. If adding the new element in old window increases the window sum then do it.
     * 4. else start = end = i, windowSum = nums[i]. This is the case where starting new window from this index makes more sense than adding the element in old window. 
     * 5. if(maxSum < WindowSum), maxSum = windowSum
     * 6. At the end of loop return maxSum.
     * 
     * @param nums input array
     * @return maximum sum of contiguous sub array
     */
    public int maxSubArray(int[] nums) { // O(n), O(1), where n is length of array.
        int windowSum = nums[0]; // O(1), O(1)
        int maxSum = nums[0]; // O(1), O(1)
        int start = 0; // O(1), O(1)
        int end = 0; // O(1), O(1)
        for(int i = 1; i < nums.length; i++) { // O(n), O(1)
            if(windowSum + nums[i] >= nums[i]) { // O(1), O(1)
                windowSum = windowSum + nums[i]; // O(1), O(1)
                end++; // O(1), O(1)
            } else {
                windowSum = nums[i]; // O(1), O(1)
                start = end = i; // O(1), O(1)
            }
            if(maxSum < windowSum) maxSum = windowSum; // O(1), O(1)
        }
        return maxSum; // O(1), O(1)
    }
    
}
