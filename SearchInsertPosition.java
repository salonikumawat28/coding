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
     * Search target in sorted array.
     * 
     * Steps:
     * 1. Initialise low = 0, high = nums.length - 1.
     * 2. Start a while loop till high > low.
     * 3. Find mid = low + (high - low + 1)/2
     * 4. If nums[mid] == target, return mid 
     * 5. else if nums[mid] > target, high = mid - 1.
     * 6. else low = mid + 1.
     * 7. At the end of loop return low.
     * @param nums is input sorted array
     * @param target is given target for match.
     * @return index value of target in input array.
     */
    public int binarySearchInsert(int[] nums, int target) { // O(logn), O(1) where n is length of array.
        int low = 0; // O(1), O(1)
        int high = nums.length - 1; // O(1), O(1)
        while(high >= low) { // O(logn), O(1)
            int mid = low + (high - low + 1)/2; // O(1), O(1)
            if(nums[mid] == target) return mid; // O(1), O(1)
            else if(nums[mid] > target) high = mid - 1; // O(1), O(1)
            else low = mid + 1; // O(1), O(1)
        }
        return low; // O(1), O(1)
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
