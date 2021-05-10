import javax.swing.tree.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 * 
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * 
 * 
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * 
 * 
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */
public class SameTree {
    public static void main(String[] args) {
        SameTree solution = new SameTree();
        
    }

    /**
     * Checking if both tree are same or not.
     * 
     * T(root1, root2) = T(left1, left2) && T(right1, right2)
     * @param root1 is input
     * @param root2 is input
     * @return if both tree are same or not.
     * 
     * TC(root1,root2) = 1 + Tc(left1,left2) + TC(right1, right2)
     * TC(n) = 1 + 2Tc(n-1) where n is minimum of h1, h2.
     * TC(n) = 1 + 2[1 + 2TC(n-2)] = 1+ 2 + 2^2TC(n-2) 
     * TC(n) = 1 + 2 + 2^2[1+ 2TC(n-3)] = 1 + 2 + 2^2 + 2^3TC(n-3)
     * .
     * .
     * .
     * TC(n) = 1 + 2 + 2^2 + ...........2^n-1
     * 
     * sum = 1(2^n - 1) / 2 - 1 = 2^n 
     * 
     * O(n) = as it cover each element of thr tree
     * 
     */
    public boolean isSameTree(TreeNode root1, TreeNode root2) { // O(2^n),  O(n)  where n is smallest height.
        if(root1 == null && root2 == null) return true; // O(1), O(1)
        if(root1 == null || root2 == null) return false; // O(1), O(1)
        if(root1.val != root2.val) return false; // O(1), O(1)
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);// O(2^n), O(n)
    }
    
}

