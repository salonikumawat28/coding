/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 * 
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 * 
 * Input: nums = [1], target = 0
 * Output: 0
 *  
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] sortArray = new int[] {1,3,5,6};
        int target = 5;
        SearchInsertPosition solution = new SearchInsertPosition();
        System.out.println(solution.searchInsert(sortArray, target));


    }

    /**
     * Search target in sorted given array.
     * 
     * steps: 
     * 1. Start a for loop i from 0 to array length - 1.
     * 2. Check if, nums[i] >= target, return i 
     * 3. At the end of loop return last possible index + 1 ie. length. This is possible when all the elements in array < then target.
     * 
     * @param nums is input sorted array
     * @param target is given target
     * @return index value of target in array.
     */
    public int searchInsert(int[] nums, int target) { // O(n), O(1) where n is length of sorted array.
        int length = nums.length; // O(1), O(1)
        for(int i = 0; i < length; i ++) { // O(n), O(1)
            if(nums[i] >= target) return i; // O(1), O(1)
        }

        // When all the elements < target, return last index + 1;
        return length; // O(1), O(1)
    }
    
}
