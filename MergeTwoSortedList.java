import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * 
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 * 
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        // ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head1 = null;
        ListNode head2 = new ListNode(0);
        MergeTwoSortedList solution = new MergeTwoSortedList();
        System.out.println(solution.mergeTwoLists(head1,head2));
    }

    /**
     * Merge two sorted linked lists.
     * 
     * Step 1: Start while loop from head till current1 and current2 becomes null.
     * Step 2: Check vals between current1 and current2 to know which is smaller.
     * Step 3: If the merge list is empty, then set mergeHead and mergeCurrent to the smaller val.
     * Step 4: If not empty, then set the smaller val at mergeCurrent.next and move the mergeCurrent to next.
     * Step 5: Move the smaller val's current to next.
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode current1 = head1; 
        ListNode current2 = head2;
        ListNode mergeHead = null;
        ListNode mergeCurrent = null;

        while(current1 != null || current2 != null) {
            boolean checkCurrent1Shorter = (current2 == null || current1.val < current2.val);
            int val = checkCurrent1Shorter ? current1.val : current2.val;

            // Add the smaller val in the merged lsit. If merge list is empty, then set the mergeHead as well.
            if(mergeHead == null) {
                mergeHead = mergeCurrent = new ListNode(val);
            } else {
                mergeCurrent.next = new ListNode(val);
                mergeCurrent = mergeCurrent.next;
            }
            
            // Move the smaller val's current to next.
            if(checkCurrent1Shorter) current1 = current1.next;
            else current2 = current2.next;
        }
        return mergeHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    
}
