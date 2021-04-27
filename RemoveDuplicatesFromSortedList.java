/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * 
 * 
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        solution.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2))));

    }

    /**
     * Remove duplicates from given Sorted List
     * 
     * Steps:
     * Initialise current = head
     * while loop current != null && current.next != null
     *   if(current.val == current.next.val)
     *     current.next = current.next.next
     *   else
     *     current = current.next
     * End loop
     * return head
     *    
     * @param head is input 
     * @return sorted list without duplicates.
     */                                                
    public ListNode deleteDuplicates(ListNode head) { // O(n), O(1) where n is length of linked list.
        ListNode current = head; // O(1), O(1)
        while(current != null && current.next != null) { // O(n), O(1)
            if(current.val == current.next.val)  current.next = current.next.next; // O(1), O(1)
            else current = current.next; // O(1), O(1)
        } 
        return head; // O(1), O(1)
    }   
}


