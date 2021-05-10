import javax.swing.tree.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *  
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *  
 * 
 * Follow up: Could you solve it both recursively and iteratively
 */
public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();
    }

    /**
     * Checking if tree is symmetic to centre of not.
     * 
     * Dividing root.left anf root.right and check for symmetry in their branches through checkSymmetry().
     * 
     * @param root is input
     * @return if given tree has mirror symmetry to centre.
     */
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root.left, root.right);
    }

    /**
     * Checking if booth the tree are mirror image or not.
     * 
     * Steps :-
     * if both root1 and root2 are null, return true.
     * if only one is null from root1 and root2, return false.
     * if value at root1 and root2 is not equal, return false.
     * Perform recursion, T(root1, root2) = T(left1, right2) && T(right1, left2).
     * 
     * @param root1 is given input.
     * @param root2 is given input.
     * @return if given tree has mirror symmetry or not.
     * 
     * Tc(root1, root2) = 1 + Tc(left1, right2) + Tc(right1, left2)
     * Tc(n) = 1 + Tc(n-1) + Tc(n-1), Assuming both left and right has nodes.
     * Tc(n) = 1 + 2Tc(n-1)
     * Tc(n) = 1 + 2[1 + 2Tc(n-2)] = 1 + 2 + 2^2Tc(n-2)
     * Tc(n) = 1 + 2 + 2^2[1 + 2Tc(n-3)] = 1 + 2 + 2^2 + 2^3Tc(n-3)
     * .
     * .
     * Tc(n) = 1 + 2 + 2^2 + 2^3 +...................+2^n-1
     * Tc(n) = 2^n where n is height of tree.
     * 
     * Tc(n) = O(n), where n is number of nodes
     * 
     * Sc(n) = all maximum path is covered = height of tree
     * 
     * 
     * TC = O(m) where m is number of nodes.
     * SC = O(log m )
     * 
     * 2^n = m
     * nlog2 2 = log2 m
     * n = log2 m = log m / log 2 = log m
     */
    public boolean checkSymmetry(TreeNode root1, TreeNode root2) { // O(2^n), O(n) where n is height of tree.
        if(root1 == null && root2 == null) return true; // O(1), O(1)
        if(root1 == null || root2 == null) return false; // O(1), O(1)
        if(root1.val != root2.val) return false; // O(1), O(1)
        return checkSymmetry(root1.left, root2.right) && checkSymmetry(root1.right, root2.left); // O(2^n), O(n)
    }
    
}
