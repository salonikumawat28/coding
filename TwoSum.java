/**
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *  
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15}; // TC = O(1), SC = O(n)
        int target = 9; // TC = O(1), SC = O(1)
        int[] output = twoSum(nums, target); // TC = O(n ^ 2), SC = O(1)
        System.out.println("Output =" +" [ " + output[0] +", " + output[1] + " ]" ); // TC = O(1), SC = O(1)
    }

    /**
     * Method for checking each element with remaining ahead elements in array such that their sum is equal to the given target.
     * @param nums input array
     * @param target sum to achieve
     * @return indices of elements whose sum is target.
     */
    private static int[] twoSum(int[] nums, int target) { // TC = O(n ^ 2), SC = O(1) , where n is length of array nums.
        int[] output = new int[2]; // TC = O(1), SC = O(1)
        for(int i = 0; i < nums.length; i++) { // TC = O(n ^ 2), SC = O(1)
            for(int j = i + 1; j < nums.length; j++) { // TC = O(n - i), SC = O(1)
                if(nums[i] + nums[j] == target) {  // TC = O(1), SC = O(1)
                    output[0] = i; // TC = O(1), SC = O(1)
                    output[1] = j; // TC = O(1), SC = O(1)
                    return output; // TC = O(1), SC = O(1)
                } 
            }
        } 
        return output; // TC = O(1), SC = O(1)
    } 
}
